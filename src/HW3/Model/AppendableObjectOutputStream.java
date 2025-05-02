package HW3.Model;

import java.io.*;
/**
 * A custom ObjectOutputStream that allows for appending objects to an existing file
 * without rewriting the stream header.
 *
 * Useful for avoiding `StreamCorruptedException` when writing multiple objects
 * across different runs of a program.
 */

public class AppendableObjectOutputStream extends ObjectOutputStream {
    private boolean append;
    private boolean initialized;
    private DataOutputStream dout;

    // Constructor used for initializing with the append flag (without OutputStream).
    protected AppendableObjectOutputStream(boolean append) throws IOException {
        super();
        this.append = append;
        this.initialized = true;
    }

    //Constructs an AppendableObjectOutputStream with an underlying OutputStream and append flag.
    public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
        super(out);
        this.append = append;
        this.initialized = true;
        this.dout = new DataOutputStream(out);
        this.writeStreamHeader();
    }
// Overridden to conditionally write the stream header.
//     If appending the header is not written to avoid corrupting the existing file.
//     throws IOException If an I/O error occurs while writing the header.
    @Override
    protected void writeStreamHeader() throws IOException {
        if (!this.initialized || this.append) return;
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }
}