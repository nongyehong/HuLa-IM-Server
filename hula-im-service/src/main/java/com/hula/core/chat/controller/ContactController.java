package com.hula.core.chat.controller;


import com.hula.common.domain.vo.req.CursorPageBaseReq;
import com.hula.common.domain.vo.req.IdReqVO;
import com.hula.common.domain.vo.resp.ApiResult;
import com.hula.common.domain.vo.resp.CursorPageBaseResp;
import com.hula.common.utils.RequestHolder;
import com.hula.core.chat.domain.vo.request.ContactFriendReq;
import com.hula.core.chat.domain.vo.response.ChatRoomResp;
import com.hula.core.chat.service.ChatService;
import com.hula.core.chat.service.RoomAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 会话相关接口
 * @author nyh
 */
@RestController
@RequestMapping("/api/chat")
@Tag(name = "聊天室相关接口")
@Slf4j
public class ContactController {
    @Resource
    private ChatService chatService;
    @Resource
    private RoomAppService roomService;

    @GetMapping("/public/contact/page")
    @Operation(summary ="会话列表")
    public ApiResult<CursorPageBaseResp<ChatRoomResp>> getRoomPage(@Valid CursorPageBaseReq request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactPage(request, uid));
    }

    @GetMapping("/public/contact/detail")
    @Operation(summary ="会话详情")
    public ApiResult<ChatRoomResp> getContactDetail(@Valid IdReqVO request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactDetail(uid, request.getId()));
    }

    @GetMapping("/public/contact/detail/friend")
    @Operation(summary ="会话详情(联系人列表发消息用)")
    public ApiResult<ChatRoomResp> getContactDetailByFriend(@Valid ContactFriendReq request) {
        Long uid = RequestHolder.get().getUid();
        return ApiResult.success(roomService.getContactDetailByFriend(uid, request.getUid()));
    }
}

