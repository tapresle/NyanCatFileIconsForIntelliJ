import com.intellij.ide.IconProvider;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.Iconable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NyanIconProvider extends IconProvider {

    @Nullable
    @Override
    public Icon getIcon(@NotNull PsiElement psiElement, @Iconable.IconFlags int i) {

        PsiFile containingFile = psiElement.getContainingFile();

        if(containingFile != null) {
            VirtualFile vFile = containingFile.getVirtualFile();
            if(vFile == null) {
                return null; // This means it's a directory
            }

            if (vFile.getExtension() == null) {
                return IconLoader.getIcon("nyan.png");
            }

            switch (vFile.getExtension()) {
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

        return null;
    }
}
