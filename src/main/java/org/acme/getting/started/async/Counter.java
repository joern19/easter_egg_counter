package org.acme.getting.started.async;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 *
 * @author not-a-robot
 */
@MongoEntity(collection="myCollection")
@RegisterForReflection
public class Counter extends PanacheMongoEntity {
        
    private long counter;
    
    public synchronized void setCounter(long value) {
        counter = value;
    }
    
    //have to name this counter. Otherwise everything after get will be name of third field.
    public synchronized long getCounter() {
        return counter;
    }
}
