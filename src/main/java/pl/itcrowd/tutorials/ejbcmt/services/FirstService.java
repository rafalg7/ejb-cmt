package pl.itcrowd.tutorials.ejbcmt.services;


import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;


@Stateless
public class FirstService {

    private static final Logger LOGGER = Logger.getLogger(FirstService.class.getCanonicalName());

    @Resource
    private TransactionSynchronizationRegistry registry;

    @Resource
    private EJBContext ejbContext;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void firstBusinessMethod(){

        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status in FirstService:"+registry.getTransactionStatus());
        LOGGER.info("Transaction in "+this.getClass().getCanonicalName()+" will be rollbacked!");
        ejbContext.setRollbackOnly();
        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status after rollback FirstService:"+registry.getTransactionStatus());


    }

}

