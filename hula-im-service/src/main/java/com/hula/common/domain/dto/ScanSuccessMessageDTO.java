package com.hula.common.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 扫码成功对象，推送给用户的消息对象
 * @author nyh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScanSuccessMessageDTO implements Serializable {
    /**
     * 推送的uid
     */
    private Integer code;

}
