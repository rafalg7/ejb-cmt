package pl.itcrowd.tutorials.ejbcmt.singletons;

import pl.itcrowd.tutorials.ejbcmt.services.FirstService;
import pl.itcrowd.tutorials.ejbcmt.services.SecondService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

@Startup
@Singleton
public class MySingleton {

    private static final Logger LOGGER = Logger.getLogger(MySingleton.class.getCanonicalName());

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private TransactionSynchronizationRegistry registry;

    @EJB
    private FirstService firstService;

    @EJB
    private SecondService secondService;

    public MySingleton() {
    }

    @PostConstruct
    public void onCreate(){
        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status before:" + registry.getTransactionStatus());
        firstService.firstBusinessMethod();
        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status after first service:" + registry.getTransactionStatus());
        secondService.secondBusinessMethod();
        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status after second service:" + registry.getTransactionStatus());
    }
}
