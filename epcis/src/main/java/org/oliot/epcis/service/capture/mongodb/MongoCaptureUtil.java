package org.oliot.epcis.service.capture.mongodb;

import org.json.JSONObject;
import org.oliot.epcis.configuration.Configuration;
import org.oliot.model.epcis.AggregationEventType;
import org.oliot.model.epcis.ObjectEventType;
import org.oliot.model.epcis.QuantityEventType;
import org.oliot.model.epcis.SensorEventType;
import org.oliot.model.epcis.TransactionEventType;
import org.oliot.model.epcis.TransformationEventType;
import org.oliot.model.epcis.VocabularyType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Copyright (C) 2014 Jaewook Jack Byun
 *
 * This project is part of Oliot (oliot.org), pursuing the implementation of
 * Electronic Product Code Information Service(EPCIS) v1.1 specification in
 * EPCglobal.
 * [http://www.gs1.org/gsmp/kc/epcglobal/epcis/epcis_1_1-standard-20140520.pdf]
 * 
 *
 * @author Jaewook Jack Byun, Ph.D student
 * 
 *         Korea Advanced Institute of Science and Technology (KAIST)
 * 
 *         Real-time Embedded System Laboratory(RESL)
 * 
 *         bjw0829@kaist.ac.kr, bjw0829@gmail.com
 */

public class MongoCaptureUtil {

	public void capture(AggregationEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}

	public void capture(ObjectEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}
	

	public void capture(QuantityEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}

	public void capture(TransactionEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}

	public void capture(TransformationEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}

	public void capture(SensorEventType event) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		mongoOperation.save(event);
		Configuration.logger.info(" Event Saved ");
		((AbstractApplicationContext) ctx).close();
	}

	public void capture(VocabularyType vocabulary) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:MongoConfig.xml");
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
				
		mongoOperation.save(vocabulary);
		Configuration.logger.info(" Vocabulary Saved ");
		((AbstractApplicationContext) ctx).close();
	}
	
	//JsonObject event capture series..
	
	@SuppressWarnings("resource")
	public void objectevent_capture(JSONObject event, MongoOperations mongoOperation){
		
		DBCollection collection = mongoOperation
				.getCollection("ObjectEvent");
		
		DBObject dbObject = (DBObject) JSON.parse(event.toString());
		
		collection.save(dbObject);
		Configuration.logger.info(" Event Saved ");
	}
	
	@SuppressWarnings("resource")
	public void aggregationevent_capture(JSONObject event, MongoOperations mongoOperation){
		
		DBCollection collection = mongoOperation
				.getCollection("AggregationEvent");
		
		DBObject dbObject = (DBObject) JSON.parse(event.toString());
		
		collection.save(dbObject);
		Configuration.logger.info(" Event Saved ");
	}
	
	@SuppressWarnings("resource")
	public void transformationevent_capture(JSONObject event, MongoOperations mongoOperation){
		DBCollection collection = mongoOperation
				.getCollection("TransformationEvent");
		
		DBObject dbObject = (DBObject) JSON.parse(event.toString());
		
		collection.save(dbObject);
		Configuration.logger.info(" Event Saved ");
	}
	
	@SuppressWarnings("resource")
	public void transactionevent_capture(JSONObject event, MongoOperations mongoOperation){
		
		DBCollection collection = mongoOperation
				.getCollection("TransactionEvent");
		
		DBObject dbObject = (DBObject) JSON.parse(event.toString());
		
		collection.save(dbObject);
		Configuration.logger.info(" Event Saved ");
	}
	
	//JsonObject Eventcapture series..
	
	
}
