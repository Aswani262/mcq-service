package com.tms.assigment.usecase;

import com.tms.assigment.restapi.req.CreateNewAssignmentReq;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public interface CreateNewAssigmentUseCase {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class CreateNewAssigment extends AssigmentCommand {
        private String subjectId;
        private List<String> topicIds;
        private String forExam;
        private int maxMarks;
        private int maxTime;
        private String assignmentType;

        public static CreateNewAssigment from(CreateNewAssignmentReq req) {
            CreateNewAssigment cmd = new CreateNewAssigment();
            cmd.assignmentType = req.getAssignmentType();
            cmd.forExam = req.getForExam();
            return cmd;
        }
    }
}
