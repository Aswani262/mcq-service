package com.tms.mcq.framework.dto;

import com.tms.mcq.framework.utils.APIResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse extends APIResponse {
    private Object result;
}
