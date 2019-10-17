package seedu.revision.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.revision.logic.commands.EditCommand;
import seedu.revision.logic.commands.EditCommand.EditAnswerableDescriptor;
import seedu.revision.model.answerable.Address;
import seedu.revision.model.answerable.Answerable;
import seedu.revision.model.answerable.Email;
import seedu.revision.model.answerable.Name;
import seedu.revision.model.answerable.Phone;
import seedu.revision.model.tag.Tag;

/**
 * A utility class to help with building EditAnswerableDescriptor objects.
 */
public class EditAnswerableDescriptorBuilder {

    private EditCommand.EditAnswerableDescriptor descriptor;

    public EditAnswerableDescriptorBuilder() {
        descriptor = new EditCommand.EditAnswerableDescriptor();
    }

    public EditAnswerableDescriptorBuilder(EditCommand.EditAnswerableDescriptor descriptor) {
        this.descriptor = new EditCommand.EditAnswerableDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditAnswerableDescriptor} with fields containing {@code answerable}'s details
     */
    public EditAnswerableDescriptorBuilder(Answerable answerable) {
        descriptor = new EditCommand.EditAnswerableDescriptor();
        descriptor.setName(answerable.getName());
        descriptor.setPhone(answerable.getPhone());
        descriptor.setEmail(answerable.getEmail());
        descriptor.setAddress(answerable.getAddress());
        descriptor.setTags(answerable.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditAnswerableDescriptor} that we are building.
     */
    public EditAnswerableDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditAnswerableDescriptor} that we are building.
     */
    public EditAnswerableDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditAnswerableDescriptor} that we are building.
     */
    public EditAnswerableDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditAnswerableDescriptor} that we are building.
     */
    public EditAnswerableDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditAnswerableDescriptor}
     * that we are building.
     */
    public EditAnswerableDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditAnswerableDescriptor build() {
        return descriptor;
    }
}
