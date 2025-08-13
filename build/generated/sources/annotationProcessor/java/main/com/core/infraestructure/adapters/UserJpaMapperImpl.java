package com.core.infraestructure.adapters;

import com.core.domain.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-07T14:09:36-0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.7 (Homebrew)"
)
@Component
public class UserJpaMapperImpl extends UserJpaMapper {

    @Override
    public User toEntity(UserJpaEntity userJpaEntity) {
        if ( userJpaEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userJpaEntity.getId() );
        user.setName( userJpaEntity.getName() );
        user.setEmail( userJpaEntity.getEmail() );

        return user;
    }

    @Override
    public UserJpaEntity toJpaEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserJpaEntity userJpaEntity = new UserJpaEntity();

        userJpaEntity.setId( user.getId() );
        userJpaEntity.setName( user.getName() );
        userJpaEntity.setEmail( user.getEmail() );

        return userJpaEntity;
    }
}
