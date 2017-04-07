package br.com.lists.repository;

import br.com.lists.domain.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Created by eric-nasc on 07/04/17.
 */
public interface ItemRepository extends CrudRepository<Item, UUID> {

    List<Item> findByListId(UUID listId);

    void deleteByListId(UUID listId);

    Item findByIdAndListId(UUID itemId, UUID listId);
}
