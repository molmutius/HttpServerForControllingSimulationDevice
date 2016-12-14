package com.github.molmutius;

import com.github.molmutius.commands.CommandList;
import com.github.molmutius.commands.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Molmu on 14.12.2016.
 */
@Controller
@RequestMapping("/simulate/{command}")
public class HttpServerController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Commands commands;

    @Autowired
    public HttpServerController(Commands commands)
    {
        this.commands = commands;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseBodyModel command(@PathVariable String command)
    {
        logger.debug(String.format("Received: '%s'", command));

        List<CommandList.Command> availableCommands = commands.getCommands();
        for(CommandList.Command cmd : availableCommands)
        {
            if(ObjectUtils.nullSafeEquals(cmd.httpCommand, command))
            {
                logger.debug(String.format("Successfully answered: '%s'", command));
                return new ResponseBodyModel("Success!");
            }
        }

        logger.debug(String.format("Could not answer: '%s'", command));
        return new ResponseBodyModel(String.format("Command '%s' not available.", command));
    }
}
