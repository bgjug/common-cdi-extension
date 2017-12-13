package bg.jug.cdi.common;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class CommonCDIExtension implements Extension {

    public void addProducers(@Observes BeforeBeanDiscovery bbd, BeanManager beanManager) {
        System.out.println("[Common ext] Adding extension types");
        bbd.addAnnotatedType(beanManager.createAnnotatedType(ExecutorServiceProducer.class));
        bbd.addAnnotatedType(beanManager.createAnnotatedType(EntityManagerProducer.class));
    }

}
