package fr.diginamic.PGDP.validators;

import fr.diginamic.PGDP.annotations.ValidDateRange;
import fr.diginamic.PGDP.entities.DateRangeValidatable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, DateRangeValidatable> {

    @Override
    public boolean isValid(DateRangeValidatable dateRangeValidatable, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate startDate = dateRangeValidatable.getStartDate();
        LocalDate endDate = dateRangeValidatable.getEndDate();

        if (endDate == null) {
            return true;
        }

        return !endDate.isBefore(startDate);
    }
}
