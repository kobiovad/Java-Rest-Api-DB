package com.example.demo;

import com.controller.start.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired // אנוטיישן שיודע שצריך ליצא מקלאס אחר
    private TopicService topicService; // נגדיר משתנה כדי למשוך פונקציות של הסרוויס

    @RequestMapping(value = "/topic",method = RequestMethod.GET)// שם של הדף שנקרא לו, בנוסף נגדיר את הפעולה הרצויה
    public List<Topic> getTopicArray(){
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.GET)
    // אם שם הארגונט שונה מהסטרינג שנרצה לקבל נכניס אנוטיישן בצמוד
    // @PathVariable {same-name} String id
    public  Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }
    //הוספת ערך לתוך הדאטה
    //יקבל נתיב מאיזה קלאס ומשתנה, נשתמש במשתנה הגלובלי ונוסיף לפי פונקציה שהכנו מראש
    // @RequestBody נוסיף אנוטיישן ריקווסט באדי כדי שהמשתנה ידע איפה הוא נכנס ומספר המשתנים הנכונים שמכילים אותו
    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
