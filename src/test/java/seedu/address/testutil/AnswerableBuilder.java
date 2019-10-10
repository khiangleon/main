package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.answerable.Answerable;
import seedu.address.model.answerable.Category;
import seedu.address.model.answerable.Difficulty;
import seedu.address.model.answerable.Question;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Answerable objects.
 */
public class AnswerableBuilder {

    public static final String DEFAULT_QUESTION = "Alice Pauline";
    public static final String DEFAULT_DIFFICULTY = "85355255";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Question question;
    private Difficulty difficulty;
    private Category category;
    private Set<Tag> tags;

    public AnswerableBuilder() {
        question = new Question(DEFAULT_QUESTION);
        difficulty = new Difficulty(DEFAULT_DIFFICULTY);
        category = new Category(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the AnswerableBuilder with the data of {@code answerableToCopy}.
     */
    public AnswerableBuilder(Answerable answerableToCopy) {
        question = answerableToCopy.getQuestion();
        difficulty = answerableToCopy.getDifficulty();
        category = answerableToCopy.getCategory();
        tags = new HashSet<>(answerableToCopy.getTags());
    }

    /**
     * Sets the {@code Question} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withQuestion(String name) {
        this.question = new Question(name);
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
     * Sets the {@code Category} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withAddress(String address) {
        this.category = new Category(address);
        return this;
    }

    /**
     * Sets the {@code Difficulty} of the {@code Answerable} that we are building.
     */
    public AnswerableBuilder withDifficulty(String difficulty) {
        this.difficulty = new Difficulty(difficulty);
        return this;
    }

    public Answerable build() {
        return new Answerable(question, difficulty, category, tags);
    }

}
