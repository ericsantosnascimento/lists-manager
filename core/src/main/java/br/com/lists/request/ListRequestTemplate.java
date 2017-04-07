package br.com.lists.request;

import br.com.lists.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.UUID;

/**
 * This is just a template, the concrete class will be generated at compile time,
 * <p> to more info reefer to -> http://immutables.github.io is a open source project, the lib main benefit is provide is implementations to use immutability and avoid boiler plate code </p>
 * <p>
 * Created by eric-nasc on 05/04/17.
 */
@Value.Immutable
@Value.Style(typeAbstract = {"*Template"}, typeImmutable = "*")
@JsonSerialize(as = ListRequest.class)
@JsonDeserialize(as = ListRequest.class)
public interface ListRequestTemplate {

    @Value.Default
    default UUID uuid() {
        return UUID.randomUUID();
    }

    String name();

}
