package com.tms.framework.dto;

import com.tms.framework.utils.APIResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResponse extends APIResponse {
    private Object result;
}
