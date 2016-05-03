package net.xiuc.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.ClusterAdminClient;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ES 客户端
 * Created by 秀川 on 16/5/3.
 */
public class ESClient {
    private Client client;
    private static final Logger log = LoggerFactory.getLogger(ESClient.class);
    private ESClient(){
        synchronized (this) {//防止正在创建client的时候调用getInstance()方法
            String[] addresses = {"127.0.0.1:9500"};
            String clusterName = "elasticsearch-local";

            Settings settings = Settings.settingsBuilder()
                    .put("client.transport.sniff", true) // sniff the rest of cluster so we only need to set one ip
                    .put("cluster.name", clusterName)
                    .put("client.transport.ping_timeout", "20s")
                    .put("client.transport.nodes_sampler_interval", "20s")
                    .build();
            TransportClient transportClient = TransportClient.builder().settings(settings).build();
            for (String address : addresses) {
                int splitPos = address.indexOf(':');
                String ip = address.substring(0, splitPos);
                int port = Integer.parseInt(address.substring(splitPos + 1));
                try {
                    transportClient = transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), port));
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                log.info("ip:" + ip + " port:" + port);
            }
            client = transportClient;
            // close when jvm was shutdown
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        log.info("look out ,we are going to close search client");
                        if (client != null) {
                            client.close();
                        }
                    } catch (Throwable e) {
                        log.error("close searchClient have exception", e);
                    }
                }
            });
        }
    }

    private static class ESClientHolder {
        private static final ESClient esClient = new ESClient();
    }

    public static ESClient getInstance() {
        return ESClientHolder.esClient;
    }

    public static Client getClient() {
        return ESClient.getInstance().client;
    }

    public IndicesAdminClient getIndicesAdminClient(){
        return getInstance().client.admin().indices();
    }

    public ClusterAdminClient getClusterAdminClient(){
        return getInstance().client.admin().cluster();
    }

}
