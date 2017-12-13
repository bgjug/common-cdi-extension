package bg.jug.cdi.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.concurrent.*;

@ApplicationScoped
public class ExecutorServiceProducer {

    @Produces
    public ExecutorService createExecutorService() {
        ExecutorService executorService;
        try {
            executorService = InitialContext.doLookup("java:comp/DefaultManagedExecutorService");
        } catch (NamingException e) {
            executorService = ForkJoinPool.commonPool();
        }

        return executorService;
    }
}
