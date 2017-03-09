/**
 * 
 */
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All objects which will be annotated with the annotation will be taken into
 * consideration for the rank.
 * 
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // on class level
public @interface Rankable {
	// no code needed
}
