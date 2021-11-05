package com.tms.mcq.domain.model;

import com.tms.mcq.application.ports.in.commands.AddNewMCQCmd;
import com.tms.mcq.application.ports.in.commands.InitNewMCQCmd;
import com.tms.mcq.domain.events.MCQInitiated;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A aggregate factory class to create aggregate
 */
public class MCQFactory {

    /**
     * Build new MCQ instance with subject code and MCQId
     * @param cmd
     * @param mcqId
     * @return
     */
    public static MCQ from(InitNewMCQCmd cmd,String mcqId) {
        MCQ mcq = new MCQ();
        mcq.setSubjectId(new SubjectRef(cmd.getSubjectId()));
        mcq.setMcqId(mcqId);
        mcq.addEvent(new MCQInitiated(mcqId));
        return mcq;
    }

    /**
     * Return Hints as set,no duplicate contain, with seqId
     * If provide hint is empty it will filter it
     * @param hintsCmd
     * @return Hint
     */
    public static Set<Hint> buildHints(List<String> hintsCmd) {
       return IntStream.range(0,hintsCmd.size()).filter(index -> hintsCmd.get(index).isBlank()).mapToObj(index -> new Hint(index,hintsCmd.get(index))).collect(Collectors.toSet());
    }

    /**Return option as set, no duplicate contain, with seqId
     * If provided option is empty it will filter it.
     * @param optionsCmd
     * @return option
     */
    public static Set<Option> buildOption(List<com.tms.mcq.application.ports.in.commands.Option> optionsCmd) {
      return optionsCmd.stream().filter(option -> option.getOptionText().isBlank()).map(optionCmd -> { return new Option(optionCmd.getOptionId(), optionCmd.getOptionText(), optionCmd.isAnswer());}).collect(Collectors.toSet());
    }

    /**Return TopicRef as set, no duplicate contain, with seqId
     * If provided option is empty it will filter it.
     * @param topicIdsCmd
     * @return TopicRef
     */
    public static Set<TopicRef> buildTopics(List<String> topicIdsCmd){
        return topicIdsCmd.stream().filter(topicId -> topicId.isBlank()).map(topicId -> new TopicRef(topicId)).collect(Collectors.toSet());
    }
}
