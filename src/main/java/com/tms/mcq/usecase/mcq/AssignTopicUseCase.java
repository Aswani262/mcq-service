package com.tms.mcq.usecase.mcq;

import com.tms.mcq.usecase.mcq.commands.MCQCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface AssignTopicUseCase {

    @NoArgsConstructor
    @Getter
    public static class AssignTopic extends MCQCommand {
        private String mcqId;
        private String topic;

        public static AssignTopic from(String mcqId, String topic) {
            AssignTopic cmd = new AssignTopic();
            cmd.mcqId = mcqId;
            cmd.topic = topic;
            cmd.validate();
            return cmd;
        }

        private void validate() {
        }
    }
}
