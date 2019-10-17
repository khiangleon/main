package seedu.revision.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.revision.model.answerable.Address;
import seedu.revision.model.answerable.Answerable;
import seedu.revision.model.answerable.Email;
import seedu.revision.model.answerable.Name;
import seedu.revision.model.answerable.Phone;
import seedu.revision.model.tag.Tag;
import seedu.revision.model.util.SampleDataUtil;

/**
 * A utility class to help with building Answerable objects.
 */
public class AnswerableBuilder {

    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    public AnswerableBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the AnswerableBuilder with the data of {@code answerableToCopy}.
     */
    public AnswerableBuilder(Answerable answerableToCopy) {
        name = answerableToCopy.getName();
        phone = answerableToCopy.getPhone();
        email = answerableToCopy.getEmail();
        address = answerableToCopy.getAddress();
        tags = new HashSet<>(answerableToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Answerable build() {
        return new Answerable(name, phone, email, address, tags);
    }

}
