package com.github.molmutius;

import com.github.molmutius.commands.CommandList;

import com.github.molmutius.commands.Commands;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Molmu on 14.12.2016.
 */
@Configuration
public class HttpServerConfiguration
{
    @Bean
    public Commands commands()
    {
        return new CommandList();
    }
}
