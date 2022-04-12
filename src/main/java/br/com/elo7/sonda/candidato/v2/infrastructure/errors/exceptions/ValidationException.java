package br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

public class ValidationException extends RuntimeException {

  private Set<String> errors;

  public ValidationException(Set<String> errors) {
    super(StringUtils.join(errors, ", "));
    this.errors = errors;
  }

  public ValidationException(String error) {
    this.errors = Sets.newHashSet(error);
  }

  public Set<String> getErrors() {
    return errors;
  }

}
