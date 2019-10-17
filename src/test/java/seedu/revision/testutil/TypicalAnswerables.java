package seedu.revision.testutil;

import static seedu.revision.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.revision.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.revision.model.RevisionTool;
import seedu.revision.model.answerable.Answerable;

/**
 * A utility class containing a list of {@code Answerable} objects to be used in tests.
 */
public class TypicalAnswerables {

    public static final Answerable ALICE = new AnswerableBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Answerable BENSON = new AnswerableBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Answerable CARL = new AnswerableBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Answerable DANIEL = new AnswerableBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Answerable ELLE = new AnswerableBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Answerable FIONA = new AnswerableBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Answerable GEORGE = new AnswerableBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Answerable HOON = new AnswerableBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Answerable IDA = new AnswerableBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Answerable's details found in {@code CommandTestUtil}
    public static final Answerable AMY = new AnswerableBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Answerable BOB = new AnswerableBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalAnswerables() {} // prevents instantiation

    /**
     * Returns a {@code RevisionTool} with all the typical answerables.
     */
    public static RevisionTool getTypicalRevisionTool() {
        RevisionTool rt = new RevisionTool();
        for (Answerable answerable : getTypicalAnswerables()) {
            rt.addAnswerable(answerable);
        }
        return rt;
    }

    public static List<Answerable> getTypicalAnswerables() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
