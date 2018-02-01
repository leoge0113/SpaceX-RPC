package com.cainiao.spacexrpc.rpc;
/*
import java.util.concurrent.Executor;

public interface SServer {
    //注册到本地
    interface ServiceRegistry {
        ServiceRegistry provider(Object serviceProvider, ProviderInterceptor... providerInterceptors);

        ServiceRegistry interfaceClass(Class[] interfaceClass);

        ServiceRegistry group(String group);

        ServiceRegistry version(String version);

        ServiceRegistry providerName(String providerName);

        ServiceRegistry weight(String weight);

        ServiceRegistry register();

        ServiceRegistry flowController(FlowController<JRequest> flowController);

        ServiceRegistry executer(Executor executor);
    }

    interface ProviderInitializer<T> {
        void init(T provider);
    }

    JAcceptor acceptor();

    SServer withAcceptor(JAcceptor acceptor);

    RegistryService registryService();

    void withGlobalInterceptors(ProviderInterceptor... globalInterceptors);

    FlowController<JRequest> globalFlowController();

    void withFlowController(FlowController<JRequest> flowController);

    ServiceRegistry serviceRegistry();

    ServiceWrapper lookupService(Directory directory);

    ServiceWrapper removeService(Directory directory);

    List<ServiceWrapper> allRegisteredServices();

    void publish(ServiceWrapper serviceWrapper);

    void publish(ServiceWrapper... serviceWrappers);

    <T> void publishWithInitializer(ServiceWrapper serviceWrapper, ProviderInitializer<T> initializer, Executor executor);

    void publishAll();

    void unpublish(ServiceWrapper serviceWrapper);

    void unpublishAll();

    void start() throws InterruptedException;

    void start(boolean sync) throws InterruptedException;

    void shutdownGracefully();
}
*/