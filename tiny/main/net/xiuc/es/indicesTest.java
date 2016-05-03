package net.xiuc.es;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

/**
 * 测试索引相关api
 * Created by 秀川 on 16/5/3.
 */
public class IndicesTest {

    private static final IndicesAdminClient indicesAdminClient = ESClient.getInstance().getIndicesAdminClient();

    public void createTestIndex(){
        IndicesAdminClient indicesAdminClient = ESClient.getInstance().getIndicesAdminClient();

        CreateIndexRequestBuilder createIndexRequestBuilder = indicesAdminClient.prepareCreate("es_index");
        Settings settings = Settings.builder()
                .put("number_of_shards", "1")
                .put("number_of_replicas", "0")
                .build();
        //设置索引中的setting
        createIndexRequestBuilder.setSettings(settings);
        XContentBuilder xContentBuilder = null;
        try {
            xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("es_index_type")//索引类型
                    .field("dynamic_date_formats", new String[] {"yyyy-MM-dd HH:mm:ss.S", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"})
                    .startObject("properties")

                    .startObject("search_field")
                    .field("type", "string")
                    .field("analyzer", "ik_max_word")
                    .field("search_analyzer", "ik_smart")
                    .endObject()

                    .endObject()
                    .endObject()
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置mapping
        createIndexRequestBuilder.addMapping("es_index_type", xContentBuilder);
        createIndexRequestBuilder.get();
    }

    public void addAliasTest() {
        IndicesAliasesRequestBuilder indicesAliasesRequestBuilder = indicesAdminClient.prepareAliases();
        indicesAliasesRequestBuilder.addAlias("es_index", "es_index_alias");
        indicesAliasesRequestBuilder.addAlias("es_index", "es_index_alias2");
        indicesAliasesRequestBuilder.get();
    }

    public void deleteAliasTest(){
        IndicesAliasesRequestBuilder indicesAliasesRequestBuilder = indicesAdminClient.prepareAliases();
        indicesAliasesRequestBuilder.removeAlias("es_index", "es_index_alias2");
        indicesAliasesRequestBuilder.get();
    }

    public static void main(String[] args) {
        IndicesTest indicesTest = new IndicesTest();
//        indicesTest.createTestIndex();//创建测试索引
//        indicesTest.addAliasTest();//设置别名
        indicesTest.deleteAliasTest();//删除别名

    }
}
