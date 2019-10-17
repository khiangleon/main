package seedu.revision.testutil;

import static seedu.revision.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.revision.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.revision.logic.commands.AddCommand;
import seedu.revision.logic.commands.EditCommand;
import seedu.revision.model.answerable.Answerable;
import seedu.revision.model.tag.Tag;

/**
 * A utility class for Answerable.
 */
public class AnswerableUtil {

    /**
     * Returns an add command string for adding the {@code answerable}.
     */
    public static String getAddCommand(Answerable answerable) {
        return AddCommand.COMMAND_WORD + " " + getAnswerablenDetails(answerable);
    }

    /**
     * Returns the part of command string for the given {@code answerable}'s details.
     */
    public static String getAnswerablenDetails(Answerable answerable) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + answerable.getName().fullName + " ");
        sb.append(PREFIX_PHONE + answerable.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + answerable.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + answerable.getAddress().value + " ");
        answerable.getTags().stream().forEach(
            s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditAnswerableDescriptor}'s details.
     */
    public static String getEditAnswerableDescriptorDetails(EditCommand.EditAnswerableDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.value).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.value).append(" "));
        descriptor.getAddress().ifPresent(address -> sb.append(PREFIX_ADDRESS).append(address.value).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_TAG);
            } else {
                tags.forEach(s -> sb.append(PREFIX_TAG).append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
