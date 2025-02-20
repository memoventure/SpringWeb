package com.github.memoventure.springweb;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController // Indicates that the class is a controller capable of handling
// HTTP requests and combines the @Controller and @ResponseBody annotations
// to facilitate returning data as HTTP responses.
@RequestMapping("/api") // Assigns a URL path to a method or controller -
// in this case, /api is considered as the prefix for the class endpoints.
public class MessageController {

    private final List<Message> messageList;

    public MessageController()
    {
        this.messageList = new ArrayList<Message>();
    }

    @GetMapping("/messages")
    public List<Message> getMessages()
    {
        return messageList;
    }

    @PostMapping("/messages") // post creates a new resource and sends data to the server
    public String addMessages(@RequestBody Message message)
    {
        messageList.add(message);
        return "Given Message was added: " + message.toString();
    }

    @DeleteMapping("/messages/remove/{id}")
    public String removeMessage(@PathVariable String id)
    {
        messageList.removeIf(message -> message.id().equals(id));
        return "Given Message was deleted.";
    }

}
