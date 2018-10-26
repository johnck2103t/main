package seedu.address.testutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.deck.Deck;

/**
 * A utility class for test cases.
 */
public class TestUtil {

    /**
     * Folder used for temp files created during testing. Ignored by Git.
     */
    private static final Path SANDBOX_FOLDER = Paths.get("src", "test", "data", "sandbox");

    /**
     * Appends {@code fileName} to the sandbox folder path and returns the resulting path.
     * Creates the sandbox folder if it doesn't exist.
     */
    public static Path getFilePathInSandboxFolder(String fileName) {
        try {
            Files.createDirectories(SANDBOX_FOLDER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SANDBOX_FOLDER.resolve(fileName);
    }

    /**
     * Returns the middle index of the deck in the {@code model}'s deck list.
     */
    public static Index getMidIndexDeck(Model model) {
        return Index.fromOneBased(model.getFilteredDeckList().size() / 2);
    }

    /**
     * Returns the middle index of the card in the {@code model}'s card list.
     */
    public static Index getMidIndexCard(Model model) {
        return Index.fromOneBased(model.getFilteredCardList().size() / 2);
    }

    /**
     * Returns the last index of the deck in the {@code model}'s deck list.
     */
    public static Index getLastIndexDeck(Model model) {
        return Index.fromOneBased(model.getFilteredDeckList().size());
    }

    /**
     * Returns the last index of the card in the {@code model}'s card list.
     */
    public static Index getLastIndexCard(Model model) {
        return Index.fromOneBased(model.getFilteredCardList().size());
    }

    /**
     * Returns the deck in the {@code model}'s deck list at {@code index}.
     */
    public static Deck getDeck(Model model, Index index) {
        return model.getFilteredDeckList().get(index.getZeroBased());
    }
}
