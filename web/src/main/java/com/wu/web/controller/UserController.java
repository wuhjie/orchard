package com.wu.web.controller;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

/**
 * @author nullacc
 */
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class UserController {


}
