package com.core.infraestructure.adapters;


import com.core.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class UserJpaMapper {

    public abstract User toEntity(UserJpaEntity userJpaEntity);
    public abstract UserJpaEntity toJpaEntity(User user);
}
