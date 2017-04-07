package br.com.lists.repository;

import br.com.lists.domain.List;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by eric-nasc on 07/04/17.
 */
public interface ListRepository extends CrudRepository<List, UUID> {
}
