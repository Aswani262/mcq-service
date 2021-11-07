package com.tms.mcq.adaptors.out.outboundservice.masterdata;

import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.MasterData;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.Subject;
import com.tms.mcq.adaptors.out.outboundservice.masterdata.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MasterDataRepo {
//    @Autowired
//    WebClient webClient;


    public MasterData findAllMasterData() {
        Topic topic = new Topic();
        topic.setCode("ASHW");

        Set<Topic> topics = new HashSet<>();
        topics.add(topic);

        Subject subject = new Subject();
        subject.setCode("TIWA");

        Set<Subject> subjects = new HashSet<>();
        subjects.add(subject);

        MasterData masterData = new MasterData();
        masterData.setSubject(subjects);
        masterData.setTopics(topics);

        return masterData;
    }
}
