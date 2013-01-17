package pl.itcrowd.tutorials.ejbcmt.services;

import pl.itcrowd.tutorials.ejbcmt.domain.BlogPost;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;


@Stateless
public class SecondService {

    private static final Logger LOGGER = Logger.getLogger(FirstService.class.getCanonicalName());

    @Resource
    private TransactionSynchronizationRegistry registry;

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void secondBusinessMethod(){

        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status in SecondService:"+registry.getTransactionStatus());
        entityManager.persist(new BlogPost("New Post!"));
        LOGGER.info("TX "+registry.getTransactionKey().toString()+" status in SecondService:"+registry.getTransactionStatus());

    }

}