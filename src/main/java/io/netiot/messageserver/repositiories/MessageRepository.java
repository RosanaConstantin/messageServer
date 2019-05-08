package io.netiot.messageserver.repositiories;

import io.netiot.messageserver.entities.Msg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Msg,Long> {
    Optional<Msg> findById(final Long messageId);

    //Iterable<Message> findAll(Sort sort);

    Page<Msg> findAll(Pageable pageable);

}
