/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.system;

import org.lwjgl.system.MemoryUtil.MemoryAllocator;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * This class can be used to programmatically set the LWJGL runtime configuration. It is an alternative to using system properties.
 *
 * <p>Care must be taken when setting <em>static</em> options. Such options are only read once or cached in {@code static final} fields. They must be
 * configured through this class before touching any other LWJGL class.</p>
 */
public class Configuration<T> {

	/**
	 * Takes priority over {@code java.library.path}. It may contain one or more directory paths, separated by {@link File#pathSeparator}.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.librarypath</b><br>
	 * &nbsp; &nbsp;Usage: Dynamic<br>
	 */
	public static final Configuration<String> LIBRARY_PATH = new Configuration<>("org.lwjgl.librarypath", StateInit.STRING);

	/**
	 * Changes the temporary directory name created by LWJGL when extracting shared libraries from JAR files. If this option is not set, it defaults to
	 * <code>lwjgl&lt;user name&gt;</code>.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.system.SharedLibraryExtractDirectory</b><br>
	 * &nbsp; &nbsp;Usage: Dynamic<br>
	 */
	public static final Configuration<String> SHARED_LIBRARY_EXTRACT_DIRECTORY = new Configuration<>(
		"org.lwjgl.system.SharedLibraryExtractDirectory",
		StateInit.STRING
	);

	/**
	 * Changes the path where LWJGL extracts shared libraries from JAR files. If this option is not set, LWJGL will try the following paths and the first
	 * successful will be used:
	 *
	 * <ul>
	 * <li>{@code System.getProperty("java.io.tmpdir")}/extractDir/crc/</li>
	 * <li>{@code System.getProperty("user.home")}/.extractDir/crc/</li>
	 * <li>.extractDir/crc/</li>
	 * <li>{@code File.createTempFile(crc)}</li>
	 * </ul>
	 *
	 * where:
	 *
	 * <pre><code>
	 * extractDir = Configuration.SHARED_LIBRARY_EXTRACT_DIRECTORY
	 * crc = CRC of the lwjgl shared library
	 * </code></pre>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.system.SharedLibraryExtractPath</b><br>
	 * &nbsp; &nbsp;Usage: Dynamic<br>
	 */
	public static final Configuration<String> SHARED_LIBRARY_EXTRACT_PATH = new Configuration<>(
		"org.lwjgl.system.SharedLibraryExtractPath",
		StateInit.STRING
	);

	/**
	 * Can be used to override the LWJGL library name. It can be an absolute path.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.libname</b><br>
	 * &nbsp; &nbsp;Usage: Dynamic<br>
	 */
	public static final Configuration<String> LIBRARY_NAME = new Configuration<>("org.lwjgl.libname", StateInit.STRING);

	/**
	 * Sets the allocator used for the {@link MemoryUtil} explicit memory management API
	 * ({@link MemoryUtil#memAlloc memAlloc}/{@link MemoryUtil#memFree memFree}/etc). Supported values:
	 *
	 * <ul>
	 * <li><em>jemalloc</em> - The allocator provided by the jemalloc library</li>
	 * <li><em>system</em> - The default system memory allocator</li>
	 * <li><em>&lt;classpath&gt;</em> - A class that implements the {@link MemoryAllocator} interface. It will be instantiated using reflection.</li>
	 * </ul>
	 *
	 * <p>When set programmatically, it can also be a {@link MemoryAllocator} instance.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.system.allocator</b><br>
	 * &nbsp; &nbsp; Type: String or a {@link MemoryAllocator} instance<br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Object> MEMORY_ALLOCATOR = new Configuration<>("org.lwjgl.system.allocator", StateInit.STRING);

	/**
	 * Sets the stack size, in kilobytes, that will be used in the default {@link MemoryStack} constructor. This value is also used for the LWJGL-managed,
	 * thread-local, {@link MemoryStack} instances.
	 *
	 * <p>If this option is not set, it defaults to 32.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.system.stackSize</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Integer> STACK_SIZE = new Configuration<>("org.lwjgl.system.stackSize", StateInit.INT);

	/**
	 * Sets the implementation used internally by LWJGL for thread-local data. Supported values:
	 *
	 * <ul>
	 * <li><em>unsafe</em> - A thread-local implementation that uses {@code Unsafe} to store per-thread data directly in {@link Thread} instances. This is the
	 * default.</li>
	 * <li><em>ThreadLocal</em> - Uses {@link ThreadLocal}.</li>
	 * </ul>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.system.tls</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<String> THREAD_LOCAL_SPACE = new Configuration<>("org.lwjgl.system.tls", StateInit.STRING);

	/**
	 * Set to true to disable LWJGL's basic checks. These are trivial checks that LWJGL performs to avoid JVM crashes, very useful during development.
	 * Their performance impact is usually minimal, but may they be disabled for release builds.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.NoChecks</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> DISABLE_CHECKS = new Configuration<>("org.lwjgl.util.NoChecks", StateInit.BOOLEAN);

	/**
	 * Set to true to enable LWJGL's debug mode. Information messages will be printed to the {@link APIUtil#DEBUG_STREAM} and extra runtime checks will
	 * be performed (some potentially expensive, performance-wise).
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.Debug</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> DEBUG = new Configuration<>("org.lwjgl.util.Debug", StateInit.BOOLEAN);

	/**
	 * Can be set to override the default {@link APIUtil#DEBUG_STREAM}. It must be the name of a class that implements the
	 * {@link Supplier Supplier&lt;PrintStream&gt;} interface. The class will be instantiated using reflection and the result of {@link Supplier#get get} will
	 * become the {@link #DEBUG_STREAM} used by LWJGL.
	 *
	 * <p>When set programmatically, it can also be a {@link PrintStream} instance. The {@link #setDebugStreamConsumer} can be used to forward debug messages
	 * to any consumer.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.DebugStream</b><br>
	 * &nbsp; &nbsp; Type: String or a {@link PrintStream} instance<br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Object> DEBUG_STREAM = new Configuration<>("org.lwjgl.util.DebugStream", StateInit.STRING);

	/**
	 * Set to true to enable LWJGL's debug mode for the {@link MemoryUtil} explicit memory management API
	 * ({@link MemoryUtil#memAlloc memAlloc}/{@link MemoryUtil#memFree memFree}/etc). All memory allocations through that API will be tracked and leaks
	 * will be reported on JVM exit. The {@code memReport} methods can also be used.
	 *
	 * <p>When this option is enabled, a stacktrace is generated on every allocation, which may negatively impact performance. If this becomes a serious issue,
	 * the JVM option {@code -XX:MaxJavaStackTraceDepth=d} (where {@code d >= 6}) can be used to reduce the overhead.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.DebugAllocator</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> DEBUG_MEMORY_ALLOCATOR = new Configuration<>("org.lwjgl.util.DebugAllocator", StateInit.BOOLEAN);

	/**
	 * Set to true to enable LWJGL's debug mode for the {@link MemoryStack}. When using the stack, each frame should be popped in the same method that pushed
	 * it. If this symmetry is broken, this mode will report it immediately.
	 *
	 * <p>When this option is enabled, a stacktrace is generated on every push or pop to the stack, which may negatively impact performance. If this becomes a
	 * serious issue, the JVM option {@code -XX:MaxJavaStackTraceDepth=d} (where {@code d >= 5}) can be used to reduce the overhead.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.DebugStack</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> DEBUG_STACK = new Configuration<>("org.lwjgl.util.DebugStack", StateInit.BOOLEAN);

	/**
	 * When enabled, capabilities classes will print an error message when they fail to retrieve a function pointer.
	 *
	 * <p>Function pointers in such classes are retrieved unconditionally, so this option may generate a lot of output and many false negatives.</p>
	 *
	 * <p>This option requires {@link #DEBUG} to be enabled.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.util.DebugFunctions</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> DEBUG_FUNCTIONS = new Configuration<>("org.lwjgl.util.DebugFunctions", StateInit.BOOLEAN);

	// -- EGL

	/**
	 * By default, LWJGL will automatically initialize the EGL library, when it is first accessed. Set this property to disable this behavior.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.egl.explicitInit</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> EGL_EXPLICIT_INIT = new Configuration<>("org.lwjgl.egl.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the EGL library (<b>org.lwjgl.egl.libname</b>). */
	public static final Configuration<String> EGL_LIBRARY_NAME = new Configuration<>("org.lwjgl.egl.libname", StateInit.STRING);

	// -- GLFW

	/** Similar to {@link #LIBRARY_NAME} for the GLFW library (<b>org.lwjgl.glfw.libname</b>). */
	public static final Configuration<String> GLFW_LIBRARY_NAME = new Configuration<>("org.lwjgl.glfw.libname", StateInit.STRING);

	/**
	 * By default, LWJGL will check if certain GLFW functions are called on the first thread of the process and fail if that is not the case. Set this property
	 * to false to disable this behavior.
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.glfw.checkThread0</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Boolean> GLFW_CHECK_THREAD0 = new Configuration<>("org.lwjgl.glfw.checkThread0", StateInit.BOOLEAN);

	// -- JEMALLOC

	/** Similar to {@link #LIBRARY_NAME} for the jemalloc library (<b>org.lwjgl.system.jemalloc.libname</b>). */
	public static final Configuration<String> JEMALLOC_LIBRARY_NAME = new Configuration<>("org.lwjgl.system.jemalloc.libname", StateInit.STRING);

	// -- OPENAL

	/** Similar to {@link #EGL_EXPLICIT_INIT} for the OpenAL library (<b>org.lwjgl.openal.explicitInit</b>). */
	public static final Configuration<Boolean> OPENAL_EXPLICIT_INIT = new Configuration<>("org.lwjgl.openal.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the OpenAL library (<b>org.lwjgl.openal.libname</b>). */
	public static final Configuration<String> OPENAL_LIBRARY_NAME = new Configuration<>("org.lwjgl.openal.libname", StateInit.STRING);

	/** Similar to {@link #OPENGL_CAPABILITIES_STATE} for the OpenAL library (<b>org.lwjgl.openal.capabilities</b>). */
	public static final Configuration<String> OPENAL_CAPABILITIES_STATE = new Configuration<>("org.lwjgl.openal.capabilities", StateInit.STRING);

	// -- OPENCL

	/** Similar to {@link #EGL_EXPLICIT_INIT} for the OpenCL library (<b>org.lwjgl.opencl.explicitInit</b>). */
	public static final Configuration<Boolean> OPENCL_EXPLICIT_INIT = new Configuration<>("org.lwjgl.opencl.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the OpenCL library (<b>org.lwjgl.opencl.libname</b>). */
	public static final Configuration<String> OPENCL_LIBRARY_NAME = new Configuration<>("org.lwjgl.opencl.libname", StateInit.STRING);

	// -- OPENGL

	/** Similar to {@link #EGL_EXPLICIT_INIT} for the OpenGL library (<b>org.lwjgl.opengl.explicitInit</b>). */
	public static final Configuration<Boolean> OPENGL_EXPLICIT_INIT = new Configuration<>("org.lwjgl.opengl.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the OpenGL library (<b>org.lwjgl.opengl.libname</b>). */
	public static final Configuration<String> OPENGL_LIBRARY_NAME = new Configuration<>("org.lwjgl.opengl.libname", StateInit.STRING);

	/**
	 * Can be used to limit the maximum available OpenGL version. This can be useful to ensure that an application has not accidentally used features only
	 * available in a higher OpenGL version.
	 *
	 * <p>When set programmatically, it can also be an {@link APIUtil.APIVersion} instance.</p>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.opengl.maxVersion</b><br>
	 * &nbsp; &nbsp; Type: String (M.n) or an {@link APIUtil.APIVersion} instance<br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<Object> OPENGL_MAXVERSION = new Configuration<>("org.lwjgl.opengl.maxVersion", StateInit.STRING);

	/**
	 * Specifies the mechanism by which {@code GLCapabilities} instances are stored and retrieved.
	 *
	 * <p>LWJGL supports multiple OpenGL contexts and each context may have different capabilities or even different function pointers. This is
	 * normally implemented using a {@link ThreadLocal}, which stores the current {@code GLCapabilities} for each thread. Due to the JVM's current inability to
	 * ideally optimize code that uses JNI methods, this results in a thread-local lookup for each OpenGL method call. To mitigate the performance impact, this
	 * option can be set to use an alternative implementation. Supported values:</p>
	 *
	 * <ul>
	 * <li><em>ThreadLocal</em> - Uses the thread-local implementation specified by {@link #THREAD_LOCAL_SPACE}. This is the default.</li>
	 * <li><em>static</em> - If it is known that an application will only create one context, or that any contexts created will use the same device and same
	 * context creation flags, this option removes all overhead from OpenGL function pointer lookups.
	 *
	 * <p>When this option is set to true, the {@code GLCapabilities} instance set before the first OpenGL function is called, will be used for all subsequent
	 * OpenGL function calls. Once set, it cannot be changed and any calls to {@code GL.setCapabilities} will be ignored.</p></li>
	 * </ul>
	 *
	 * <p style="font-family: monospace">
	 * Property: <b>org.lwjgl.opengl.capabilities</b><br>
	 * &nbsp; &nbsp;Usage: Static<br>
	 */
	public static final Configuration<String> OPENGL_CAPABILITIES_STATE = new Configuration<>("org.lwjgl.opengl.capabilities", StateInit.STRING);

	// -- OPENGL ES

	/** Similar to {@link #EGL_EXPLICIT_INIT} for the OpenGL ES library (<b>org.lwjgl.opengles.explicitInit</b>). */
	public static final Configuration<Boolean> OPENGLES_EXPLICIT_INIT = new Configuration<>("org.lwjgl.opengles.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the OpenGL ES library (<b>org.lwjgl.opengles.libname</b>). */
	public static final Configuration<String> OPENGLES_LIBRARY_NAME = new Configuration<>("org.lwjgl.opengles.libname", StateInit.STRING);

	/** Similar to {@link #OPENGL_MAXVERSION} for the OpenGL ES library (<b>org.lwjgl.opengles.maxVersion</b>). */
	public static final Configuration<Object> OPENGLES_MAXVERSION = new Configuration<>("org.lwjgl.opengles.maxVersion", StateInit.STRING);

	/** Similar to {@link #OPENGL_CAPABILITIES_STATE} for the OpenGL ES library (<b>org.lwjgl.opengles.capabilities</b>). */
	public static final Configuration<String> OPENGLES_CAPABILITIES_STATE = new Configuration<>("org.lwjgl.opengles.capabilities", StateInit.STRING);

	// -- VULKAN

	/** Similar to {@link #EGL_EXPLICIT_INIT} for the Vulkan library (<b>org.lwjgl.vulkan.explicitInit</b>). */
	public static final Configuration<Boolean> VULKAN_EXPLICIT_INIT = new Configuration<>("org.lwjgl.vulkan.explicitInit", StateInit.BOOLEAN);

	/** Similar to {@link #LIBRARY_NAME} for the Vulkan library (<b>org.lwjgl.vulkan.libname</b>). */
	public static final Configuration<String> VULKAN_LIBRARY_NAME = new Configuration<>("org.lwjgl.vulkan.libname", StateInit.STRING);

	private abstract static class StateInit<T> {
		static final StateInit<Boolean> BOOLEAN = new StateInit<Boolean>() {
			@Override
			Boolean getState(String property) {
				String value = System.getProperty(property);
				return value == null ? null : Boolean.parseBoolean(value);
			}
		};

		static final StateInit<Integer> INT = new StateInit<Integer>() {
			@Override
			Integer getState(String property) {
				return Integer.getInteger(property);
			}
		};

		static final StateInit<String> STRING = new StateInit<String>() {
			@Override
			String getState(String property) {
				return System.getProperty(property);

			}
		};

		abstract T getState(String property);
	}

	private final String property;

	private T state;

	Configuration(String property, StateInit<? extends T> init) {
		this.property = property;
		this.state = init.getState(property);
	}

	public String getProperty() {
		return property;
	}

	/**
	 * Sets the option value.
	 *
	 * @param value the value to set
	 */
	public void set(T value) {
		this.state = value;
	}

	/**
	 * Returns the option value.
	 *
	 * <p>If the option value has not been set, null will be returned.</p>
	 */
	public T get() {
		return state;
	}

	/**
	 * Returns the option value.
	 *
	 * <p>If the option value has not been set, the specified default value will be returned.</p>
	 *
	 * @param defaultValue the default value
	 */
	public T get(T defaultValue) {
		T state = this.state;
		if ( state == null )
			state = defaultValue;

		return state;
	}

	/**
	 * Configures the {@link #DEBUG_STREAM} to forward all messages to the specified consumer.
	 *
	 * @param consumer the debug message consumer
	 */
	public static void setDebugStreamConsumer(Consumer<String> consumer) {
		setDebugStreamConsumer(consumer, Charset.forName("UTF-8"));
	}

	/**
	 * Configures the {@link #DEBUG_STREAM} to forward all messages to the specified consumer.
	 *
	 * @param consumer the debug message consumer
	 * @param charset  the message charset
	 */
	public static void setDebugStreamConsumer(Consumer<String> consumer, Charset charset) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream(128) {

			private final CharsetDecoder decoder = charset.newDecoder();

			private byte[] tmp;
			private ByteBuffer in;
			private CharBuffer out;

			@Override
			public void flush() throws IOException {
				if ( buf != tmp ) {
					tmp = buf;

					out = CharBuffer.allocate(tmp.length);
					in = ByteBuffer.wrap(tmp);
				} else {
					out.clear();
					in.position(0);
				}

				in.limit(count);

				decoder.reset();
				decoder.decode(in, out, true);

				out.flip();
				consumer.accept(out.toString());

				this.reset();
			}
		};

		DEBUG_STREAM.set(
			// The default implementation flushes unconditionally.
			// We flush on a newline only.
			// TODO: search the entire string?
			System.getProperty("line.separator").length() == 2 ?
				// \r\n
				new PrintStream(buffer, false) {
					@Override
					public void write(byte[] b, int off, int len) {
						int last = off + len - 1;
						if ( b[last] == '\n' ) {
							buffer.write(b, off, len - (off < last && b[last - 1] == '\r' ? 2 : 1));
							flush();
						} else
							buffer.write(b, off, len);
					}
				} :
				// \n
				new PrintStream(buffer, false) {
					@Override
					public void write(byte[] b, int off, int len) {
						if ( b[off + len - 1] == '\n' ) {
							buffer.write(b, off, len - 1);
							flush();
						} else
							buffer.write(b, off, len);
					}
				}
		);
	}

}