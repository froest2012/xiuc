package net.xiuc.es;

import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequestBuilder;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsRequestBuilder;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.Map;

/**
 * 测试索引相关api
 * Created by 秀川 on 16/5/3.
 */
public class IndicesTest {

    private static final IndicesAdminClient indicesAdminClient = ESClient.getInstance().getIndicesAdminClient();

    public void createIndicesExample(){
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

    public void deleteIndicesExample(){
//        DeleteIndexRequest deleteIndexRequest = Requests.deleteIndexRequest("es_index");
//        indicesAdminClient.delete(deleteIndexRequest);
        DeleteIndexRequestBuilder deleteIndexRequestBuilder = indicesAdminClient.prepareDelete("es_index");
        deleteIndexRequestBuilder.get();
    }

    public void getIndicesExample() {
        GetIndexRequestBuilder getIndexRequestBuilder = indicesAdminClient.prepareGetIndex();
        getIndexRequestBuilder.get();
    }

    public void putMappingExample() {
        //1. 一个PutMappingRequestBuilder只能添加一个type以及对于的mapping
        PutMappingRequestBuilder putMappingRequestBuilder = indicesAdminClient.preparePutMapping("es_index");
        XContentBuilder xContentBuilder = null;
//        try {
//            xContentBuilder = XContentFactory.jsonBuilder()
//                    .startObject()
//                    .startObject("es_index_type1")//索引类型
//                    .field("dynamic_date_formats", new String[] {"yyyy-MM-dd HH:mm:ss.S", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"})
//                    .startObject("properties")
//
//                    .startObject("search_field")
//                    .field("type", "string")
//                    .field("analyzer", "ik_max_word")
//                    .field("search_analyzer", "ik_smart")
//                    .endObject()
//
//                    .endObject()
//                    .endObject()
//                    .endObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        PutMappingResponse putMappingResponse = putMappingRequestBuilder
//                .setType("es_index_type1").setSource(xContentBuilder)
//                .get();
//        System.out.println(putMappingResponse.isAcknowledged());

        //2. 添加字段
        try {
            xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("es_index_type1")//索引类型
                    .startObject("properties")

                    .startObject("user_name")
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
        putMappingRequestBuilder.setType("es_index_type1").setSource(xContentBuilder);
        putMappingRequestBuilder.get();
    }

    public void getIndicesMappingExample() throws IOException {
        GetMappingsRequestBuilder getMappingsRequestBuilder = indicesAdminClient.prepareGetMappings("es_index");
        GetMappingsResponse getMappingsResponse = getMappingsRequestBuilder.get();
        ImmutableOpenMap<String, ImmutableOpenMap<String, MappingMetaData>> immutableOpenMap = getMappingsResponse.getMappings();
        ImmutableOpenMap<String, MappingMetaData> map = immutableOpenMap.get("es_index");
        MappingMetaData mappingMetaData = map.get("es_index_type");
        Map<String, Object> sourceMap = mappingMetaData.getSourceAsMap();
        Map<String, Object> properties = (Map<String, Object>) sourceMap.get("properties");
        Map<String, Object> fieldValues = (Map<String, Object>) properties.get("search_field");
        System.out.println(fieldValues.get("analyzer"));
    }

    public void getIndicesSettingsExample(){
        GetSettingsRequestBuilder getSettingsRequestBuilder = indicesAdminClient.prepareGetSettings("es_index");
        GetSettingsResponse getSettingsResponse = getSettingsRequestBuilder.get();
        //获取es_index索引中的number_of_shards的settings的值
        String numOfShards = getSettingsResponse.getSetting("es_index","index.number_of_shards");
        System.out.println(numOfShards);
    }

    public void indicesExist() {
        IndicesExistsRequestBuilder indicesExistsRequestBuilder = indicesAdminClient.prepareExists("es_index");
        IndicesExistsResponse indicesExistsResponse = indicesExistsRequestBuilder.get();
        System.out.println(indicesExistsResponse.isExists());;
    }

    public void closeIndicesExist() {
        CloseIndexRequestBuilder closeIndexRequestBuilder = indicesAdminClient.prepareClose("es_index");
        CloseIndexResponse closeIndexResponse = closeIndexRequestBuilder.get();
        System.out.println(closeIndexResponse.isAcknowledged());
    }

    public void openIndicesExist() {
        OpenIndexRequestBuilder openIndexRequestBuilder = indicesAdminClient.prepareOpen("es_index");
        OpenIndexResponse openIndexResponse = openIndexRequestBuilder.get();
        System.out.println(openIndexResponse.isAcknowledged());
    }

    public void addAliasExample() {
        IndicesAliasesRequestBuilder indicesAliasesRequestBuilder = indicesAdminClient.prepareAliases();
        indicesAliasesRequestBuilder.addAlias("es_index", "es_index_alias");
        indicesAliasesRequestBuilder.addAlias("es_index", "es_index_alias2");
        indicesAliasesRequestBuilder.get();
    }

    public void deleteAliasExample(){
        IndicesAliasesRequestBuilder indicesAliasesRequestBuilder = indicesAdminClient.prepareAliases();
        indicesAliasesRequestBuilder.removeAlias("es_index", "es_index_alias2");
        indicesAliasesRequestBuilder.get();
    }

    public static void main(String[] args) throws IOException {
        IndicesTest indicesTest = new IndicesTest();
//        indicesTest.createIndicesExample();//创建测试索引
//        indicesTest.deleteIndicesExample();//删除索引
//        indicesTest.addAliasExample();//设置别名
//        indicesTest.deleteAliasExample();//删除别名
//        indicesTest.getIndicesExample();//获取索引的所有信息
//        indicesTest.getIndicesMappingExample();//获取指定索引的mapping
//        indicesTest.getIndicesSettingsExample();//获取指定索引的setting
//        indicesTest.indicesExist();//判断索引是否存在
//        indicesTest.closeIndicesExist();//关闭索引,搜索关闭以后就不可以被搜索
//        indicesTest.openIndicesExist();//打开索引
        indicesTest.putMappingExample();//1. 添加type以及对于的mapping;2. 添加字段
    }
}
