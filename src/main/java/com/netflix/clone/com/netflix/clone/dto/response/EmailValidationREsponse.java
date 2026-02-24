package com.netflix.clone.com.netflix.clone.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmailValidationREsponse {
    private boolean exists;
    private boolean available;

}
