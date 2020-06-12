package com.consumer.Dao;

import com.consumer.Model.Notify;
import com.consumer.Model.NotifyQueueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public class NotificationDaoImpl {
    @Autowired
     NotificationDao notificationDao;
    public Notify insert(NotifyQueueRequest notifyQueueRequest) {
        if(exist(notifyQueueRequest)){
            Notify notify=findById(notifyQueueRequest);
            notify.setuseridList(notifyQueueRequest.getUserid());
            return notificationDao.save(notify);
        }
          else{
              Notify notify= new Notify(notifyQueueRequest);

            return notificationDao.save(notify);
          }
    }
    public boolean exist(NotifyQueueRequest notifyQueueRequest){
     return notificationDao.existsById(notifyQueueRequest.getProductid());
    }
    public Notify findById(NotifyQueueRequest notifyQueueRequest){
        Optional<Notify> notifyList=notificationDao.findById(notifyQueueRequest.getProductid());
        return notifyList.get();
    }
}