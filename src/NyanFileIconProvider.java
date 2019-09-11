import com.intellij.ide.FileIconProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NyanFileIconProvider implements FileIconProvider {

    @Nullable
    @Override
    public Icon getIcon(@NotNull VirtualFile virtualFile, @Iconable.IconFlags int i, @Nullable Project project) {
        if (virtualFile.getExtension() == null) {
            return IconLoader.getIcon("nyan.png");
        }

        switch (virtualFile.getExtension()) {
            case "ts":
            case "tsx":
            case "js":
            case "jsx":
                return IconLoader.getIcon("gb.png");
            case "css":
            case "scss":
            case "sass":
            case "less":
                return IconLoader.getIcon("pikanyan.png");
            case "md":
                return IconLoader.getIcon("floppy.png");
            default:
                return IconLoader.getIcon("nyan.png");
        }
    }
}
