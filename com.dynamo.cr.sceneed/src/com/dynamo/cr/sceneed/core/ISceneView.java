package com.dynamo.cr.sceneed.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.vecmath.Point3d;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.dynamo.cr.editor.core.ILogger;

public interface ISceneView {

    public interface IPresenter {
        void onSelect(IStructuredSelection selection);
        void onSelectAll();
        void onRefresh();

        void onLoad(String type, InputStream contents) throws IOException, CoreException;

        void onSave(OutputStream contents, IProgressMonitor monitor) throws IOException, CoreException;
        void onResourceChanged(IResourceChangeEvent event) throws CoreException;

        void onDeleteSelection(IPresenterContext presenterContext);
        void onCopySelection(IPresenterContext presenterContext, ILoaderContext loaderContext, IProgressMonitor monitor) throws IOException, CoreException;
        void onCutSelection(IPresenterContext presenterContext, ILoaderContext loaderContext, IProgressMonitor monitor) throws IOException, CoreException;
        void onPasteIntoSelection(IPresenterContext presenterContext) throws IOException, CoreException;
        void onDNDMoveSelection(IPresenterContext presenterContext, List<Node> copies, Node targetParent);
        void onDNDDuplicateSelection(IPresenterContext presenterContext, List<Node> copies, Node targetParent);
    }

    public interface IPresenterContext extends ILogger {
        // Model interface
        IStructuredSelection getSelection();
        void setSelection(IStructuredSelection selection);
        void executeOperation(IUndoableOperation operation);

        // View interface
        void refreshView();
        void refreshRenderView();
        void asyncExec(Runnable runnable);
        String selectFromList(String title, String message, String... lst);
        Object selectFromArray(String title, String message, Object[] input, ILabelProvider labelProvider);
        String selectFile(String title, String[] extensions);
        void getCameraFocusPoint(Point3d focusPoint);
        INodeType getNodeType(Class<? extends Node> nodeClass);
    }

    public interface INodePresenter<T extends Node> {}

    void setRoot(Node root);
    void refresh(IStructuredSelection selection, boolean dirty);
    void refreshRenderView();
    void asyncExec(Runnable runnable);

    String selectFromList(String title, String message, String... lst);
    Object selectFromArray(String title, String message, Object[] input, ILabelProvider labelProvider);
    String selectFile(String title, String[] extensions);

    void getCameraFocusPoint(Point3d focusPoint);

}
