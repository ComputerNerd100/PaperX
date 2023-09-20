package io.papermc.paper.api.exception;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Thrown when a plugin's scheduler fails with an exception
 */
public class ServerSchedulerException extends ServerPluginException {

    private final PaperTask task;

    public ServerSchedulerException(String message, Throwable cause, PaperTask task) {
        super(message, cause, task.getOwner());
        this.task = checkNotNull(task, "task");
    }

    public ServerSchedulerException(Throwable cause, PaperTask task) {
        super(cause, task.getOwner());
        this.task = checkNotNull(task, "task");
    }

    protected ServerSchedulerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, PaperTask task) {
        super(message, cause, enableSuppression, writableStackTrace, task.getOwner());
        this.task = checkNotNull(task, "task");
    }

    /**
     * Gets the task which threw the exception
     *
     * @return exception throwing task
     */
    public PaperTask getTask() {
        return task;
    }
}

