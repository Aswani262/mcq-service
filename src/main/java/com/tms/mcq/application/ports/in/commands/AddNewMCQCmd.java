package com.tms.mcq.application.ports.in.commands;

import com.tms.mcq.application.ports.in.AddNewMCQUseCase;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class AddNewMCQCmd extends MCQCommand {
    private String mcqId;
    private String questionText;
    private List<Option> options;
    private String subjectId;
    private String topicId;
    private List<String> hints;
    private List<Integer> yearInAsked;

    private AddNewMCQCmd(String questionText, List<Option> options){
        this.questionText = questionText;
        this.options = options;
    }

    public List<String> validate(){
        List<String> errors = new ArrayList<>();
        if(this.questionText == null){
            errors.add("Question Text can not be null");
        }
        return errors;
    }


    public static AddNewMCQCmd from(Map<String, Object> request) {
        AddNewMCQCmd cmd = new AddNewMCQCmd((String)request.get("questionText"),(List<Option>)request.get("option"));
//        if(!cmd.validate().isEmpty()) {
//
//            throw
//        };
      return cmd;
    }
}
