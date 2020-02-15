package com.example.demo;

import com.controller.start.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //
public class TopicService {
//כדי לקבל את הדאטה בייס כרשימה נוכל ליצור ליסט  כרגע לצורך הדוגמא נממש את הליסט מתוך קלאס יעודי
// נשים לב לפאבליק ופרייוט כדי לא להתבלבל כאשר נמשוך את הדאטה
    private List <Topic> topics = new ArrayList<> (Arrays.asList(
            new Topic("spring","springFrameWork","spring Description"),
            new Topic("java","Core Java","Core Java Discription"),
            new Topic("javascript","javaScript FrameWork","javaScript Description")));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public  Topic getTopic(String id){
      return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
      //פונקציית למדה שמייצאת ספציפית את המשתנה ומשווה אותו עם הערך של הדאטה
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for(int i =0;i<topics.size();i++){
            Topic t=topics.get(i); // נוציא כל שורה בדאטה לפי אינדקס ונשווה אלמנט ספציפי ואז נחליף
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t-> t.getId().equals(id)); // נשתמש בפונקציית למדה למציאת האלמנט בדאטה לפי האלמנט שנשלח
    }
}

