
package local_project.createclient_api_1_0;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: createClient_API Purpose: <br>
 * Description: <br>
 * 
 * @author luiz.honorato@outlook.com
 * @version 7.3.1.20200219_1130
 * @status
 */
public class createClient_API implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "createClient_API.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(createClient_API.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "1.0";
	private final String jobName = "createClient_API";
	private final String projectName = "LOCAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	StatCatcherUtils tStatCatcher_1 = new StatCatcherUtils("_UsLcYIFGEe6osYQNKL18nA", "1.0");
	JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_UsLcYIFGEe6osYQNKL18nA", "1.0");
	org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					createClient_API.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(createClient_API.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tPostjob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tStatCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tStatCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tStatCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_1_TXMLMAP_OUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tXMLMap_1_TXMLMAP_IN_error(exception, errorComponent, globalMap);

	}

	public void tXMLMap_1_TXMLMAP_IN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPostjob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTClient_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tStatCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPostjob_1 begin ] start
				 */

				ok_Hash.put("tPostjob_1", false);
				start_Hash.put("tPostjob_1", System.currentTimeMillis());

				currentComponent = "tPostjob_1";

				int tos_count_tPostjob_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tPostjob_1", "tPostjob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tPostjob_1 begin ] stop
				 */

				/**
				 * [tPostjob_1 main ] start
				 */

				currentComponent = "tPostjob_1";

				tos_count_tPostjob_1++;

				/**
				 * [tPostjob_1 main ] stop
				 */

				/**
				 * [tPostjob_1 process_data_begin ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_begin ] stop
				 */

				/**
				 * [tPostjob_1 process_data_end ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_end ] stop
				 */

				/**
				 * [tPostjob_1 end ] start
				 */

				currentComponent = "tPostjob_1";

				ok_Hash.put("tPostjob_1", true);
				end_Hash.put("tPostjob_1", System.currentTimeMillis());

				/**
				 * [tPostjob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tPostjob_1 finally ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tPrejob_1", "tPrejob");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				/**
				 * [tPrejob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}

	public static class outSqlCreateStruct implements routines.system.IPersistableRow<outSqlCreateStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_createClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_createClient_API = new byte[0];

		public String clientDoc;

		public String getClientDoc() {
			return this.clientDoc;
		}

		public String clientName;

		public String getClientName() {
			return this.clientName;
		}

		public BigDecimal value;

		public BigDecimal getValue() {
			return this.value;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_createClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_createClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_createClient_API) {

				try {

					int length = 0;

					this.clientDoc = readString(dis);

					this.clientName = readString(dis);

					this.value = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.clientDoc, dos);

				// String

				writeString(this.clientName, dos);

				// BigDecimal

				dos.writeObject(this.value);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("clientDoc=" + clientDoc);
			sb.append(",clientName=" + clientName);
			sb.append(",value=" + String.valueOf(value));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (clientDoc == null) {
				sb.append("<null>");
			} else {
				sb.append(clientDoc);
			}

			sb.append("|");

			if (clientName == null) {
				sb.append("<null>");
			} else {
				sb.append(clientName);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(outSqlCreateStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_createClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_createClient_API = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_createClient_API) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_createClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_createClient_API = new byte[0];

		public Integer statusCode;

		public Integer getStatusCode() {
			return this.statusCode;
		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public String string;

		public String getString() {
			return this.string;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_createClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_createClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_createClient_API) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("statusCode=" + String.valueOf(statusCode));
			sb.append(",body=" + String.valueOf(body));
			sb.append(",string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (statusCode == null) {
				sb.append("<null>");
			} else {
				sb.append(statusCode);
			}

			sb.append("|");

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tRESTClient_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTClient_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				row2Struct row2 = new row2Struct();
				outSqlCreateStruct outSqlCreate = new outSqlCreateStruct();

				/**
				 * [tFlowToIterate_1 begin ] start
				 */

				TalendThreadPool mtp_tFixedFlowInput_1 = new TalendThreadPool(2);

				globalMap.put("lockWrite_tFixedFlowInput_1", new Object[0]);
				int threadIdCounter_tFixedFlowInput_1 = 0;

				int NB_ITERATE_tFixedFlowInput_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_1", false);
				start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_1";

				if (enableLogStash) {
					runStat.log(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tFlowToIterate_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFlowToIterate_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
							log4jParamters_tFlowToIterate_1.append("Parameters:");
							log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "false");
							log4jParamters_tFlowToIterate_1.append(" | ");
							log4jParamters_tFlowToIterate_1
									.append("MAP" + " = " + "[{VALUE=" + ("body") + ", KEY=" + ("\"body\"") + "}]");
							log4jParamters_tFlowToIterate_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_1 - " + (log4jParamters_tFlowToIterate_1));
						}
					}
					new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFlowToIterate_1", "tFlowToIterate");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tFlowToIterate_1 = 0;
				int counter_tFlowToIterate_1 = 0;

				/**
				 * [tFlowToIterate_1 begin ] stop
				 */

				/**
				 * [tRESTClient_1 begin ] start
				 */

				ok_Hash.put("tRESTClient_1", false);
				start_Hash.put("tRESTClient_1", System.currentTimeMillis());

				currentComponent = "tRESTClient_1";

				int tos_count_tRESTClient_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTClient_1", "tRESTClient");
					talendJobLogProcess(globalMap);
				}

				/**
				 * [tRESTClient_1 begin ] stop
				 */

				/**
				 * [tRESTClient_1 main ] start
				 */

				currentComponent = "tRESTClient_1";

				row1 = null;

// expected response body
				Object responseDoc_tRESTClient_1 = null;

				try {
					// request body
					org.dom4j.Document requestDoc_tRESTClient_1 = null;
					String requestString_tRESTClient_1 = null;

					Object requestBody_tRESTClient_1 = requestDoc_tRESTClient_1 != null ? requestDoc_tRESTClient_1
							: requestString_tRESTClient_1;

					// resposne class name
					Class<?> responseClass_tRESTClient_1 = org.dom4j.Document.class;

					// create web client instance
					org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_1 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

					boolean inOSGi = routines.system.BundleUtils.inOSGi();

					final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_1 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

					String url = "www.testLuizEquadis";
					// {baseUri}tRESTClient
					factoryBean_tRESTClient_1.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
					factoryBean_tRESTClient_1.setAddress(url);

					factoryBean_tRESTClient_1.setFeatures(features_tRESTClient_1);

					java.util.List<Object> providers_tRESTClient_1 = new java.util.ArrayList<Object>();
					providers_tRESTClient_1.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
						// workaround for https://jira.talendforge.org/browse/TESB-7276
						public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls, java.lang.reflect.Type type,
								java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt,
								javax.ws.rs.core.MultivaluedMap<String, String> headers, java.io.InputStream is)
								throws IOException, javax.ws.rs.WebApplicationException {
							String contentLength = headers.getFirst("Content-Length");
							if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
									&& Integer.valueOf(contentLength) <= 0) {
								try {
									return org.dom4j.DocumentHelper.parseText("<root/>");
								} catch (org.dom4j.DocumentException e_tRESTClient_1) {
									e_tRESTClient_1.printStackTrace();
								}
								return null;
							}
							return super.readFrom(cls, type, anns, mt, headers, is);
						}
					});
					org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_1 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
					jsonProvider_tRESTClient_1.setIgnoreNamespaces(true);
					jsonProvider_tRESTClient_1.setAttributesToElements(true);

					jsonProvider_tRESTClient_1.setSupportUnwrapped(true);
					jsonProvider_tRESTClient_1.setWrapperName("root");

					jsonProvider_tRESTClient_1.setDropRootElement(false);
					jsonProvider_tRESTClient_1.setConvertTypesToStrings(false);
					providers_tRESTClient_1.add(jsonProvider_tRESTClient_1);
					factoryBean_tRESTClient_1.setProviders(providers_tRESTClient_1);
					factoryBean_tRESTClient_1.setTransportId("http://cxf.apache.org/transports/http");

					boolean use_auth_tRESTClient_1 = false;

					org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_1 = factoryBean_tRESTClient_1
							.createWebClient();

					// set request path
					webClient_tRESTClient_1.path("/createclient");

					// set connection properties
					org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_1 = org.apache.cxf.jaxrs.client.WebClient
							.getConfig(webClient_tRESTClient_1);
					org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_1 = clientConfig_tRESTClient_1
							.getHttpConduit();

					if (clientConfig_tRESTClient_1.getEndpoint() != null
							&& clientConfig_tRESTClient_1.getEndpoint().getEndpointInfo() != null) {
						clientConfig_tRESTClient_1.getEndpoint().getEndpointInfo()
								.setProperty("enable.webclient.operation.reporting", true);
					}

					if (!inOSGi) {
						conduit_tRESTClient_1.getClient().setReceiveTimeout((long) (60 * 1000L));
						conduit_tRESTClient_1.getClient().setConnectionTimeout((long) (30 * 1000L));
						boolean use_proxy_tRESTClient_1 = false;

					}

					// set Accept-Type
					webClient_tRESTClient_1.accept("application/xml");

					// set optional query and header properties if any

					if (use_auth_tRESTClient_1 && "OAUTH2_BEARER".equals("BASIC")) {
						// set oAuth2 bearer token
						webClient_tRESTClient_1.header("Authorization", "Bearer " + "");
					}

					// if FORM request then capture query parameters into Form, otherwise set them
					// as queries

					try {
						// start send request

						responseDoc_tRESTClient_1 = webClient_tRESTClient_1.get(responseClass_tRESTClient_1);

						int webClientResponseStatus_tRESTClient_1 = webClient_tRESTClient_1.getResponse().getStatus();
						if (webClientResponseStatus_tRESTClient_1 >= 300) {
							throw new javax.ws.rs.WebApplicationException(webClient_tRESTClient_1.getResponse());
						}

						if (row1 == null) {
							row1 = new row1Struct();
						}

						row1.statusCode = webClientResponseStatus_tRESTClient_1;

						{
							Object responseObj_tRESTClient_1 = responseDoc_tRESTClient_1;

							if (responseObj_tRESTClient_1 != null) {
								if (responseClass_tRESTClient_1 == String.class) {
									row1.string = (String) responseObj_tRESTClient_1;
								} else {
									routines.system.Document responseTalendDoc_tRESTClient_1 = null;
									if (null != responseObj_tRESTClient_1) {
										responseTalendDoc_tRESTClient_1 = new routines.system.Document();
										responseTalendDoc_tRESTClient_1
												.setDocument((org.dom4j.Document) responseObj_tRESTClient_1);
									}
									row1.body = responseTalendDoc_tRESTClient_1;
								}
							}
						}

						globalMap.put("tRESTClient_1_HEADERS", webClient_tRESTClient_1.getResponse().getHeaders());

					} catch (javax.ws.rs.WebApplicationException ex_tRESTClient_1) {

						throw ex_tRESTClient_1;

					}

				} catch (Exception e_tRESTClient_1) {

					throw new TalendException(e_tRESTClient_1, currentComponent, globalMap);

				}

				tos_count_tRESTClient_1++;

				/**
				 * [tRESTClient_1 main ] stop
				 */

				/**
				 * [tRESTClient_1 process_data_begin ] start
				 */

				currentComponent = "tRESTClient_1";

				/**
				 * [tRESTClient_1 process_data_begin ] stop
				 */
// Start of branch "row1"
				if (row1 != null) {

					/**
					 * [tFlowToIterate_1 main ] start
					 */

					currentComponent = "tFlowToIterate_1";

					if (enableLogStash) {
						runStat.log(iterateId, 1, 1, "row1");
					}

					if (log.isTraceEnabled()) {
						log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
					}

					if (log.isTraceEnabled())
						log.trace("tFlowToIterate_1 - " + ("Set global var, key=") + ("body") + (", value=")
								+ (row1.body) + ("."));
					globalMap.put("body", row1.body);
					nb_line_tFlowToIterate_1++;
					counter_tFlowToIterate_1++;
					if (log.isDebugEnabled())
						log.debug("tFlowToIterate_1 - " + ("Current iteration is: ") + (counter_tFlowToIterate_1)
								+ ("."));
					globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);

					tos_count_tFlowToIterate_1++;

					/**
					 * [tFlowToIterate_1 main ] stop
					 */

					/**
					 * [tFlowToIterate_1 process_data_begin ] start
					 */

					currentComponent = "tFlowToIterate_1";

					/**
					 * [tFlowToIterate_1 process_data_begin ] stop
					 */
					NB_ITERATE_tFixedFlowInput_1++;

					class tFixedFlowInput_1Thread extends TalendThread {// implements
																		// routines.system.TalendThreadPool.PropertySettable
						class ThreadedMap extends java.util.HashMap<String, Object> {

							private static final long serialVersionUID = 0L;

							public ThreadedMap(java.util.Map<String, Object> globalMap) {
								super(globalMap);
							}

							@Override
							public Object put(String key, Object value) {

								synchronized (createClient_API.this.obj) {

									super.put(key, value);
									return createClient_API.this.globalMap.put(key, value);

								}

							}
						}

						private java.util.Map<String, Object> globalMap = null;
						boolean isRunning = false;
						String iterateId = "";

						row1Struct row1 = new row1Struct();
						row2Struct row2 = new row2Struct();
						outSqlCreateStruct outSqlCreate = new outSqlCreateStruct();

						public tFixedFlowInput_1Thread(java.util.Map<String, Object> globalMap, row1Struct row1,
								row2Struct row2, outSqlCreateStruct outSqlCreate, int threadID) {
							super();

							if (row1 != null) {

								this.row1.statusCode = row1.statusCode;

								this.row1.body = row1.body;

								this.row1.string = row1.string;

							}

							if (row2 != null) {

								this.row2.body = row2.body;

							}

							if (outSqlCreate != null) {

								this.outSqlCreate.clientDoc = outSqlCreate.clientDoc;

								this.outSqlCreate.clientName = outSqlCreate.clientName;

								this.outSqlCreate.value = outSqlCreate.value;

							}

							synchronized (createClient_API.this.obj) {
								this.globalMap = new ThreadedMap(globalMap);

							}
							iterateId = "." + threadID;

						}

						public void run() {

							java.util.Map threadRunResultMap = new java.util.HashMap();
							threadRunResultMap.put("errorCode", null);
							threadRunResultMap.put("status", "");
							threadLocal.set(threadRunResultMap);

							this.isRunning = true;
							String currentComponent = "";
							java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

							String currentVirtualComponent = null;

							try {

								/**
								 * [tXMLMap_1_TXMLMAP_OUT begin ] start
								 */

								ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", false);
								start_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());

								currentVirtualComponent = "tXMLMap_1";

								currentComponent = "tXMLMap_1_TXMLMAP_OUT";

								if (enableLogStash) {
									runStat.log(resourceMap, iterateId, 0, 0, "row2");
								}

								int tos_count_tXMLMap_1_TXMLMAP_OUT = 0;

								if (log.isDebugEnabled())
									log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Start to work."));
								if (log.isDebugEnabled()) {
									class BytesLimit65535_tXMLMap_1_TXMLMAP_OUT {
										public void limitLog4jByte() throws Exception {
											StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_OUT = new StringBuilder();
											log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("Parameters:");
											log4jParamters_tXMLMap_1_TXMLMAP_OUT
													.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
											log4jParamters_tXMLMap_1_TXMLMAP_OUT.append(" | ");
											if (log.isDebugEnabled())
												log.debug("tXMLMap_1_TXMLMAP_OUT - "
														+ (log4jParamters_tXMLMap_1_TXMLMAP_OUT));
										}
									}
									new BytesLimit65535_tXMLMap_1_TXMLMAP_OUT().limitLog4jByte();
								}
								if (enableLogStash) {
									talendJobLog.addCM("tXMLMap_1_TXMLMAP_OUT", "tXMLMapOut");
									talendJobLogProcess(globalMap);
								}

//===============================input xml init part===============================
								class XML_API_tXMLMap_1_TXMLMAP_OUT {
									public boolean isDefNull(org.dom4j.Node node)
											throws javax.xml.transform.TransformerException {
										if (node != null && node instanceof org.dom4j.Element) {
											org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
											if (attri != null && ("true").equals(attri.getText())) {
												return true;
											}
										}
										return false;
									}

									public boolean isMissing(org.dom4j.Node node)
											throws javax.xml.transform.TransformerException {
										return node == null ? true : false;
									}

									public boolean isEmpty(org.dom4j.Node node)
											throws javax.xml.transform.TransformerException {
										if (node != null) {
											return node.getText().length() == 0;
										}
										return false;
									}
								}
								class Var__tXMLMap_1_TXMLMAP_OUT__Struct {
								}
								Var__tXMLMap_1_TXMLMAP_OUT__Struct Var__tXMLMap_1_TXMLMAP_OUT = new Var__tXMLMap_1_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
								outSqlCreateStruct outSqlCreate_tmp = new outSqlCreateStruct();
								outSqlCreateStruct outSqlCreate_save = null;
//the aggregate variable
								outSqlCreateStruct outSqlCreate_aggregate = null;
								int count_outSqlCreate_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
								java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
								globalMap.put("allOutsForAggregate_tXMLMap_1", allOutsForAggregate_tXMLMap_1);
// ###############################
								class TreeNode_API_tXMLMap_1_TXMLMAP_OUT {
									java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();

									void clear() {
										xpath_value_map.clear();
									}

									void put(String xpath, String value) {
										xpath_value_map.put(xpath, value);
									}

									String get_null(String xpath) {
										return null;
									}

									String get_String(String xpath) {
										return xpath_value_map.get(xpath);
									}

									BigDecimal get_BigDecimal(String xpath) {
										String content = xpath_value_map.get(xpath);
										if (content == null || content.length() == 0)
											return null;
										return ParserUtils.parseTo_BigDecimal(content);
									}
								}
								TreeNode_API_tXMLMap_1_TXMLMAP_OUT treeNodeAPI_tXMLMap_1_TXMLMAP_OUT = new TreeNode_API_tXMLMap_1_TXMLMAP_OUT();
								NameSpaceTool nsTool_tXMLMap_1_TXMLMAP_OUT = new NameSpaceTool();
								int nb_line_tXMLMap_1_TXMLMAP_OUT = 0;

								XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

								// the map store the previous value of aggregate columns
								java.util.Map<String, Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String, Object>();

								/**
								 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
								 */

								/**
								 * [tFixedFlowInput_1 begin ] start
								 */

								ok_Hash.put("tFixedFlowInput_1", false);
								start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

								currentComponent = "tFixedFlowInput_1";

								int tos_count_tFixedFlowInput_1 = 0;

								if (enableLogStash) {
									talendJobLog.addCM("tFixedFlowInput_1", "tFixedFlowInput");
									talendJobLogProcess(globalMap);
								}

								for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

									row2.body = ((Document) globalMap.get("body"));

									/**
									 * [tFixedFlowInput_1 begin ] stop
									 */

									/**
									 * [tFixedFlowInput_1 main ] start
									 */

									currentComponent = "tFixedFlowInput_1";

									tos_count_tFixedFlowInput_1++;

									/**
									 * [tFixedFlowInput_1 main ] stop
									 */

									/**
									 * [tFixedFlowInput_1 process_data_begin ] start
									 */

									currentComponent = "tFixedFlowInput_1";

									/**
									 * [tFixedFlowInput_1 process_data_begin ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_OUT main ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_OUT";

									if (enableLogStash) {
										runStat.log(iterateId, 1, 1, "row2");
									}

									if (log.isTraceEnabled()) {
										log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
									}

									boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
									boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
									boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
									boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;

									// init document to flat tool
									routines.system.DocumentToFlat docToFlat_tXMLMap_1_TXMLMAP_OUT = new routines.system.DocumentToFlat();
									docToFlat_tXMLMap_1_TXMLMAP_OUT.setOriginalLoop("/root");
									docToFlat_tXMLMap_1_TXMLMAP_OUT.setIsOptional(false);
									if (row2.body == null || row2.body.getDocument() == null) {
										throw new RuntimeException("row2.body can't be empty");
									}
									org.dom4j.Document doc_tXMLMap_1_TXMLMAP_OUT = row2.body.getDocument();
									docToFlat_tXMLMap_1_TXMLMAP_OUT.setDoc(doc_tXMLMap_1_TXMLMAP_OUT);
									docToFlat_tXMLMap_1_TXMLMAP_OUT.setDefineNS(false);
									docToFlat_tXMLMap_1_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_1_TXMLMAP_OUT);

									// old version, find NS from doc
									nsTool_tXMLMap_1_TXMLMAP_OUT.countNSMap(doc_tXMLMap_1_TXMLMAP_OUT.getRootElement());
									java.util.HashMap<String, String> xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT = nsTool_tXMLMap_1_TXMLMAP_OUT.xmlNameSpaceMap;

									docToFlat_tXMLMap_1_TXMLMAP_OUT
											.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT);

									String[] absolutePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[3];
									String[] relativePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[3];

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "row2.body:/root/clientName";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "clientName";

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "row2.body:/root/initialValue";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "initialValue";

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[2] = "row2.body:/root/clientDoc";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[2] = "clientDoc";

									docToFlat_tXMLMap_1_TXMLMAP_OUT
											.setAbsolutePathMappings(absolutePathMappings_tXMLMap_1_TXMLMAP_OUT);
									docToFlat_tXMLMap_1_TXMLMAP_OUT
											.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_1_TXMLMAP_OUT);
									// generate document to flat data
									docToFlat_tXMLMap_1_TXMLMAP_OUT.flat();
									// get flat data
									java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_1_TXMLMAP_OUT = docToFlat_tXMLMap_1_TXMLMAP_OUT
											.getResultSet();

									for (java.util.Map<String, String> oneRow_tXMLMap_1_TXMLMAP_OUT : resultSet_tXMLMap_1_TXMLMAP_OUT) { // G_TXM_M_001
										nb_line_tXMLMap_1_TXMLMAP_OUT++;
										rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
										rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
										mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
										isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;

										treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.clear();
										for (java.util.Map.Entry<String, String> entry_tXMLMap_1_TXMLMAP_OUT : oneRow_tXMLMap_1_TXMLMAP_OUT
												.entrySet()) {
											treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.put(entry_tXMLMap_1_TXMLMAP_OUT.getKey(),
													entry_tXMLMap_1_TXMLMAP_OUT.getValue());
										}

										{ // start of Var scope

											// ###############################
											// # Vars tables

											Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
											// ###############################
											// # Output tables

											outSqlCreate = null;

// # Output table : 'outSqlCreate'
											count_outSqlCreate_tXMLMap_1_TXMLMAP_OUT++;

											outSqlCreate_tmp = new outSqlCreateStruct();
											outSqlCreate_tmp.clientDoc = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
													.get_String("row2.body:/root/clientDoc");
											outSqlCreate_tmp.clientName = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
													.get_String("row2.body:/root/clientName");
											outSqlCreate_tmp.value = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
													.get_BigDecimal("row2.body:/root/initialValue");
											allOutsForAggregate_tXMLMap_1.add(outSqlCreate_tmp);

											log.debug("tXMLMap_1 - Outputting the record "
													+ count_outSqlCreate_tXMLMap_1_TXMLMAP_OUT
													+ " of the output table 'outSqlCreate'.");

// ###############################

										} // end of Var scope

										rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;

									} // G_TXM_M_001 close

									tos_count_tXMLMap_1_TXMLMAP_OUT++;

									/**
									 * [tXMLMap_1_TXMLMAP_OUT main ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_OUT";

									/**
									 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_OUT";

									/**
									 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
									 */

									/**
									 * [tFixedFlowInput_1 process_data_end ] start
									 */

									currentComponent = "tFixedFlowInput_1";

									/**
									 * [tFixedFlowInput_1 process_data_end ] stop
									 */

									/**
									 * [tFixedFlowInput_1 end ] start
									 */

									currentComponent = "tFixedFlowInput_1";

								}
								globalMap.put("tFixedFlowInput_1_NB_LINE", 1);

								ok_Hash.put("tFixedFlowInput_1", true);
								end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

								/**
								 * [tFixedFlowInput_1 end ] stop
								 */

								/**
								 * [tXMLMap_1_TXMLMAP_OUT end ] start
								 */

								currentVirtualComponent = "tXMLMap_1";

								currentComponent = "tXMLMap_1_TXMLMAP_OUT";

								log.debug("tXMLMap_1 - Written records count in the table 'outSqlCreate': "
										+ count_outSqlCreate_tXMLMap_1_TXMLMAP_OUT + ".");

								if (enableLogStash) {

									if (runStat.log(resourceMap, iterateId, "row2", 2, 0, talendJobLog,
											"tFixedFlowInput_1", "tFixedFlowInput", "tXMLMap_1_TXMLMAP_OUT",
											"tXMLMapOut", "output")) {
										talendJobLogProcess(globalMap);
									}

								}

								if (log.isDebugEnabled())
									log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Done."));

								ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", true);
								end_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());

								/**
								 * [tXMLMap_1_TXMLMAP_OUT end ] stop
								 */

								/**
								 * [tDBOutput_1 begin ] start
								 */

								ok_Hash.put("tDBOutput_1", false);
								start_Hash.put("tDBOutput_1", System.currentTimeMillis());

								currentComponent = "tDBOutput_1";

								if (enableLogStash) {
									runStat.log(resourceMap, iterateId, 0, 0, "outSqlCreate");
								}

								int tos_count_tDBOutput_1 = 0;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Start to work."));
								if (log.isDebugEnabled()) {
									class BytesLimit65535_tDBOutput_1 {
										public void limitLog4jByte() throws Exception {
											StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
											log4jParamters_tDBOutput_1.append("Parameters:");
											log4jParamters_tDBOutput_1
													.append("USE_EXISTING_CONNECTION" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("DRIVER" + " = " + "JTDS");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"testequadis\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"1433\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("DB_SCHEMA" + " = " + "\"\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"testequadis\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("USER" + " = " + "\"testequadis\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf(
													"enc:routine.encryption.key.v1:QI8KW12ARgsEChX0WXp4ecf10FUWg4U+H/s8JQ==")
													.substring(0, 4) + "...");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"testequadis\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "NONE");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("IDENTITY_INSERT" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1
													.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "true");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1
													.append("DATASOURCE_ALIAS" + " = " + "\"string_testequadis\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "\"\"");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1
													.append("IGNORE_DATE_OUTOF_RANGE" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
											log4jParamters_tDBOutput_1.append(" | ");
											log4jParamters_tDBOutput_1
													.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlOutput");
											log4jParamters_tDBOutput_1.append(" | ");
											if (log.isDebugEnabled())
												log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
										}
									}
									new BytesLimit65535_tDBOutput_1().limitLog4jByte();
								}
								if (enableLogStash) {
									talendJobLog.addCM("tDBOutput_1", "tMSSqlOutput");
									talendJobLogProcess(globalMap);
								}

								int nb_line_tDBOutput_1 = 0;
								int nb_line_update_tDBOutput_1 = 0;
								int nb_line_inserted_tDBOutput_1 = 0;
								int nb_line_deleted_tDBOutput_1 = 0;
								int nb_line_rejected_tDBOutput_1 = 0;

								int deletedCount_tDBOutput_1 = 0;
								int updatedCount_tDBOutput_1 = 0;
								int insertedCount_tDBOutput_1 = 0;
								int rejectedCount_tDBOutput_1 = 0;
								String dbschema_tDBOutput_1 = null;
								String tableName_tDBOutput_1 = null;
								boolean whetherReject_tDBOutput_1 = false;

								java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
								long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
								long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
								long year10000_tDBOutput_1 = TalendDate
										.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00").getTime();
								long date_tDBOutput_1;

								java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar
										.getInstance(java.util.TimeZone.getTimeZone("UTC"));

								java.sql.Connection conn_tDBOutput_1 = null;
								String dbUser_tDBOutput_1 = null;
								java.util.Map<String, routines.system.TalendDataSource> dataSources_tDBOutput_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
										.get(KEY_DB_DATASOURCES);
								if (null != dataSources_tDBOutput_1) {
									String dsAlias_tDBOutput_1 = "string_testequadis";
									if (dataSources_tDBOutput_1.get(dsAlias_tDBOutput_1) == null) {
										throw new RuntimeException(
												"No DataSource with alias: " + dsAlias_tDBOutput_1 + " available!");
									}
									conn_tDBOutput_1 = dataSources_tDBOutput_1.get(dsAlias_tDBOutput_1).getConnection();
								} else {

									dbschema_tDBOutput_1 = "";
									String driverClass_tDBOutput_1 = "net.sourceforge.jtds.jdbc.Driver";

									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + (driverClass_tDBOutput_1)
												+ ("."));
									java.lang.Class.forName(driverClass_tDBOutput_1);
									String port_tDBOutput_1 = "1433";
									String dbname_tDBOutput_1 = "testequadis";
									String url_tDBOutput_1 = "jdbc:jtds:sqlserver://" + "testequadis";
									if (!"".equals(port_tDBOutput_1)) {
										url_tDBOutput_1 += ":" + "1433";
									}
									if (!"".equals(dbname_tDBOutput_1)) {
										url_tDBOutput_1 += "//" + "testequadis";

									}
									url_tDBOutput_1 += ";appName=" + projectName + ";" + "";
									dbUser_tDBOutput_1 = "testequadis";

									final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil
											.decryptPassword(
													"enc:routine.encryption.key.v1:mFklmNgt+nWxoLELc+mWjoXueG9C81M8+Fal1w==");

									String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
												+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
									conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,
											dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1)
												+ ("' has succeeded."));

								}

								resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

								conn_tDBOutput_1.setAutoCommit(false);
								int commitEvery_tDBOutput_1 = 10000;
								int commitCounter_tDBOutput_1 = 0;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
											+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));
								int batchSize_tDBOutput_1 = 10000;
								int batchSizeCounter_tDBOutput_1 = 0;

								if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
									tableName_tDBOutput_1 = "testequadis";
								} else {
									tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "testequadis";
								}
								int count_tDBOutput_1 = 0;

								String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
										+ "] ([clientDoc],[clientName],[value]) VALUES (?,?,?)";
								java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
										.prepareStatement(insert_tDBOutput_1);
								resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

								/**
								 * [tDBOutput_1 begin ] stop
								 */

								/**
								 * [tXMLMap_1_TXMLMAP_IN begin ] start
								 */

								ok_Hash.put("tXMLMap_1_TXMLMAP_IN", false);
								start_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());

								currentVirtualComponent = "tXMLMap_1";

								currentComponent = "tXMLMap_1_TXMLMAP_IN";

								int tos_count_tXMLMap_1_TXMLMAP_IN = 0;

								if (log.isDebugEnabled())
									log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Start to work."));
								if (log.isDebugEnabled()) {
									class BytesLimit65535_tXMLMap_1_TXMLMAP_IN {
										public void limitLog4jByte() throws Exception {
											StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_IN = new StringBuilder();
											log4jParamters_tXMLMap_1_TXMLMAP_IN.append("Parameters:");
											log4jParamters_tXMLMap_1_TXMLMAP_IN
													.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
											log4jParamters_tXMLMap_1_TXMLMAP_IN.append(" | ");
											if (log.isDebugEnabled())
												log.debug("tXMLMap_1_TXMLMAP_IN - "
														+ (log4jParamters_tXMLMap_1_TXMLMAP_IN));
										}
									}
									new BytesLimit65535_tXMLMap_1_TXMLMAP_IN().limitLog4jByte();
								}
								if (enableLogStash) {
									talendJobLog.addCM("tXMLMap_1_TXMLMAP_IN", "tXMLMapIn");
									talendJobLogProcess(globalMap);
								}

								java.util.List<Object> outs_tXMLMap_1 = (java.util.List<Object>) globalMap
										.get("allOutsForAggregate_tXMLMap_1");
								for (Object row_out_tXMLMap_1_TXMLMAP_IN : outs_tXMLMap_1) {// TD512

									/**
									 * [tXMLMap_1_TXMLMAP_IN begin ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_IN main ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_IN";

									outSqlCreate = null;
									if (row_out_tXMLMap_1_TXMLMAP_IN != null
											&& row_out_tXMLMap_1_TXMLMAP_IN instanceof outSqlCreateStruct) {
										outSqlCreate = (outSqlCreateStruct) row_out_tXMLMap_1_TXMLMAP_IN;
									}

									tos_count_tXMLMap_1_TXMLMAP_IN++;

									/**
									 * [tXMLMap_1_TXMLMAP_IN main ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_IN";

									/**
									 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
									 */
// Start of branch "outSqlCreate"
									if (outSqlCreate != null) {

										/**
										 * [tDBOutput_1 main ] start
										 */

										currentComponent = "tDBOutput_1";

										if (enableLogStash) {
											runStat.log(iterateId, 1, 1, "outSqlCreate");
										}

										if (log.isTraceEnabled()) {
											log.trace("outSqlCreate - "
													+ (outSqlCreate == null ? "" : outSqlCreate.toLogString()));
										}

										whetherReject_tDBOutput_1 = false;
										if (outSqlCreate.clientDoc == null) {
											pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(1, outSqlCreate.clientDoc);
										}

										if (outSqlCreate.clientName == null) {
											pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(2, outSqlCreate.clientName);
										}

										pstmt_tDBOutput_1.setBigDecimal(3, outSqlCreate.value);

										pstmt_tDBOutput_1.addBatch();
										nb_line_tDBOutput_1++;

										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
													+ (" to the ") + ("INSERT") + (" batch."));
										batchSizeCounter_tDBOutput_1++;

										////////// batch execute by batch size///////
										class LimitBytesHelper_tDBOutput_1 {
											public int limitBytePart1(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT")
																+ (" batch."));
													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
																+ (" batch execution has succeeded."));
												} catch (java.sql.BatchUpdateException e) {

													int countSum_tDBOutput_1 = 0;
													for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
														counter += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}

													log.error("tDBOutput_1 - " + (e.getMessage()));
													System.err.println(e.getMessage());

												}
												return counter;
											}

											public int limitBytePart2(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT")
																+ (" batch."));
													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
																+ (" batch execution has succeeded."));
												} catch (java.sql.BatchUpdateException e) {

													for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
														counter += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}

													log.error("tDBOutput_1 - " + (e.getMessage()));
													System.err.println(e.getMessage());

												}
												return counter;
											}
										}
										if ((batchSize_tDBOutput_1 > 0)
												&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

											insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
													.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

											batchSizeCounter_tDBOutput_1 = 0;
										}

										//////////// commit every////////////

										commitCounter_tDBOutput_1++;
										if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
											if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

												insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
														.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

												batchSizeCounter_tDBOutput_1 = 0;
											}

											if (log.isDebugEnabled())
												log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
														+ (commitCounter_tDBOutput_1) + (" record(s)."));
											conn_tDBOutput_1.commit();

											if (log.isDebugEnabled())
												log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
											commitCounter_tDBOutput_1 = 0;
										}

										tos_count_tDBOutput_1++;

										/**
										 * [tDBOutput_1 main ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_begin ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_begin ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_end ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_end ] stop
										 */

									} // End of branch "outSqlCreate"

									/**
									 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_IN";

									/**
									 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_IN end ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_IN";

								} // TD512

								if (log.isDebugEnabled())
									log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Done."));

								ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
								end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());

								/**
								 * [tXMLMap_1_TXMLMAP_IN end ] stop
								 */

								/**
								 * [tDBOutput_1 end ] start
								 */

								currentComponent = "tDBOutput_1";

								try {
									int countSum_tDBOutput_1 = 0;
									if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
												break;
											}
											countSum_tDBOutput_1 += countEach_tDBOutput_1;
										}

										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
									}

									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

								} catch (java.sql.BatchUpdateException e) {

									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}

									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

									log.error("tDBOutput_1 - " + (e.getMessage()));
									System.err.println(e.getMessage());

								}
								if (pstmt_tDBOutput_1 != null) {

									pstmt_tDBOutput_1.close();
									resourceMap.remove("pstmt_tDBOutput_1");

								}
								resourceMap.put("statementClosed_tDBOutput_1", true);
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
											+ (commitCounter_tDBOutput_1) + (" record(s)."));
								conn_tDBOutput_1.commit();

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								conn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
								resourceMap.put("finish_tDBOutput_1", true);

								nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
								nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
								nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
								nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

								globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
								globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
								globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
								globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
								globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ")
											+ (nb_line_inserted_tDBOutput_1) + (" record(s)."));

								if (enableLogStash) {

									if (runStat.log(resourceMap, iterateId, "outSqlCreate", 2, 0, talendJobLog,
											"tXMLMap_1_TXMLMAP_IN", "tXMLMapIn", "tDBOutput_1", "tMSSqlOutput",
											"output")) {
										talendJobLogProcess(globalMap);
									}

								}

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Done."));

								ok_Hash.put("tDBOutput_1", true);
								end_Hash.put("tDBOutput_1", System.currentTimeMillis());

								/**
								 * [tDBOutput_1 end ] stop
								 */

							} catch (java.lang.Exception e) {
								this.status = "failure";
								Integer localErrorCode = (Integer) (((java.util.Map) threadLocal.get())
										.get("errorCode"));
								if (localErrorCode != null) {
									if (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {
										this.errorCode = localErrorCode;
									}
								}

								TalendException te = new TalendException(e, currentComponent, globalMap);

								te.setVirtualComponentName(currentVirtualComponent);

								this.exception = te;
								talendThreadPool.setErrorThread(this);
								talendThreadPool.stopAllWorkers();

							} catch (java.lang.Error error) {
								this.status = "failure";
								Integer localErrorCode = (Integer) (((java.util.Map) threadLocal.get())
										.get("errorCode"));
								if (localErrorCode != null) {
									if (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {
										this.errorCode = localErrorCode;
									}
								}
								this.error = error;
								talendThreadPool.setErrorThread(this);
								talendThreadPool.stopAllWorkers();
							} finally {
								try {

									/**
									 * [tFixedFlowInput_1 finally ] start
									 */

									currentComponent = "tFixedFlowInput_1";

									/**
									 * [tFixedFlowInput_1 finally ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_OUT finally ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_OUT";

									/**
									 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
									 */

									/**
									 * [tXMLMap_1_TXMLMAP_IN finally ] start
									 */

									currentVirtualComponent = "tXMLMap_1";

									currentComponent = "tXMLMap_1_TXMLMAP_IN";

									/**
									 * [tXMLMap_1_TXMLMAP_IN finally ] stop
									 */

									/**
									 * [tDBOutput_1 finally ] start
									 */

									currentComponent = "tDBOutput_1";

									try {
										if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
											java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
											if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
													.remove("pstmt_tDBOutput_1")) != null) {
												pstmtToClose_tDBOutput_1.close();
											}
										}
									} finally {
										if (resourceMap.get("finish_tDBOutput_1") == null) {
											java.sql.Connection ctn_tDBOutput_1 = null;
											if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap
													.get("conn_tDBOutput_1")) != null) {
												try {
													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - "
																+ ("Closing the connection to the database."));
													ctn_tDBOutput_1.close();
													if (log.isDebugEnabled())
														log.debug("tDBOutput_1 - "
																+ ("Connection to the database has closed."));
												} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
													String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
															+ sqlEx_tDBOutput_1.getMessage();
													log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
													System.err.println(errorMessage_tDBOutput_1);
												}
											}
										}
									}

									/**
									 * [tDBOutput_1 finally ] stop
									 */

								} catch (java.lang.Exception e) {
									// ignore
								} catch (java.lang.Error error) {
									// ignore
								}
								resourceMap = null;
							}
							this.isRunning = false;

							Integer localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get("errorCode"));
							String localStatus = (String) (((java.util.Map) threadLocal.get()).get("status"));
							if (localErrorCode != null) {
								if (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {
									this.errorCode = localErrorCode;
								}
							}
							if (!this.status.equals("failure")) {
								this.status = localStatus;
							}

							talendThreadPool.getTalendThreadResult().setErrorCode(this.errorCode);
							talendThreadPool.getTalendThreadResult().setStatus(this.status);
						}
					}

					tFixedFlowInput_1Thread bt_tFixedFlowInput_1 = new tFixedFlowInput_1Thread(globalMap, row1, row2,
							outSqlCreate, threadIdCounter_tFixedFlowInput_1++);
					mtp_tFixedFlowInput_1.execute(bt_tFixedFlowInput_1);

					/**
					 * [tFlowToIterate_1 process_data_end ] start
					 */

					currentComponent = "tFlowToIterate_1";

					/**
					 * [tFlowToIterate_1 process_data_end ] stop
					 */

				} // End of branch "row1"

				/**
				 * [tRESTClient_1 process_data_end ] start
				 */

				currentComponent = "tRESTClient_1";

				/**
				 * [tRESTClient_1 process_data_end ] stop
				 */

				/**
				 * [tRESTClient_1 end ] start
				 */

				currentComponent = "tRESTClient_1";

				if (globalMap.get("tRESTClient_1_NB_LINE") == null) {
					globalMap.put("tRESTClient_1_NB_LINE", 1);
				}

// [tRESTCliend_end]

				ok_Hash.put("tRESTClient_1", true);
				end_Hash.put("tRESTClient_1", System.currentTimeMillis());

				/**
				 * [tRESTClient_1 end ] stop
				 */

				/**
				 * [tFlowToIterate_1 end ] start
				 */

				currentComponent = "tFlowToIterate_1";

				globalMap.put("tFlowToIterate_1_NB_LINE", nb_line_tFlowToIterate_1);
				if (enableLogStash) {

					if (runStat.log(resourceMap, iterateId, "row1", 2, 0, talendJobLog, "tRESTClient_1", "tRESTClient",
							"tFlowToIterate_1", "tFlowToIterate", "output")) {
						talendJobLogProcess(globalMap);
					}

				}

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Done."));

				ok_Hash.put("tFlowToIterate_1", true);
				end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				mtp_tFixedFlowInput_1.waitForEndOfQueue();

				TalendThread errorThread_tFixedFlowInput_1 = mtp_tFixedFlowInput_1.getErrorThread();

				if (errorThread_tFixedFlowInput_1 != null) {
					if (errorThread_tFixedFlowInput_1.errorCode != null) {
						if (errorCode == null || errorThread_tFixedFlowInput_1.errorCode.compareTo(errorCode) > 0) {
							errorCode = errorThread_tFixedFlowInput_1.errorCode;
						}
					}
					if (!status.equals("failure")) {
						status = errorThread_tFixedFlowInput_1.status;
					}
					if (errorThread_tFixedFlowInput_1.exception != null) {
						throw errorThread_tFixedFlowInput_1.exception;
					}
					if (errorThread_tFixedFlowInput_1.error != null) {
						throw errorThread_tFixedFlowInput_1.error;
					}
				} else {
					Integer threadErrorCode = mtp_tFixedFlowInput_1.getTalendThreadResult().getErrorCode();
					String threadStatus = mtp_tFixedFlowInput_1.getTalendThreadResult().getStatus();

					if (threadErrorCode != null) {
						if (errorCode == null || threadErrorCode.compareTo(errorCode) > 0) {
							errorCode = threadErrorCode;
						}
					}
					if (!status.equals("failure")) {
						status = threadStatus;
					}
				}

				/**
				 * [tFlowToIterate_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tRESTClient_1 finally ] start
				 */

				currentComponent = "tRESTClient_1";

				/**
				 * [tRESTClient_1 finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				currentComponent = "tFlowToIterate_1";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTClient_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_createClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_createClient_API = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public Long system_pid;

		public Long getSystem_pid() {
			return this.system_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String job_repository_id;

		public String getJob_repository_id() {
			return this.job_repository_id;
		}

		public String job_version;

		public String getJob_version() {
			return this.job_version;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message_type;

		public String getMessage_type() {
			return this.message_type;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Long duration;

		public Long getDuration() {
			return this.duration;
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_createClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_createClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_createClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_createClient_API, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_createClient_API) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.father_pid = readString(dis);

					this.root_pid = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.system_pid = null;
					} else {
						this.system_pid = dis.readLong();
					}

					this.project = readString(dis);

					this.job = readString(dis);

					this.job_repository_id = readString(dis);

					this.job_version = readString(dis);

					this.context = readString(dis);

					this.origin = readString(dis);

					this.message_type = readString(dis);

					this.message = readString(dis);

					length = dis.readByte();
					if (length == -1) {
						this.duration = null;
					} else {
						this.duration = dis.readLong();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.root_pid, dos);

				// Long

				if (this.system_pid == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeLong(this.system_pid);
				}

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.job_repository_id, dos);

				// String

				writeString(this.job_version, dos);

				// String

				writeString(this.context, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message_type, dos);

				// String

				writeString(this.message, dos);

				// Long

				if (this.duration == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeLong(this.duration);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",system_pid=" + String.valueOf(system_pid));
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",job_repository_id=" + job_repository_id);
			sb.append(",job_version=" + job_version);
			sb.append(",context=" + context);
			sb.append(",origin=" + origin);
			sb.append(",message_type=" + message_type);
			sb.append(",message=" + message);
			sb.append(",duration=" + String.valueOf(duration));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (system_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(system_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (job_repository_id == null) {
				sb.append("<null>");
			} else {
				sb.append(job_repository_id);
			}

			sb.append("|");

			if (job_version == null) {
				sb.append("<null>");
			} else {
				sb.append(job_version);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message_type == null) {
				sb.append("<null>");
			} else {
				sb.append(message_type);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (duration == null) {
				sb.append("<null>");
			} else {
				sb.append(duration);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tStatCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tStatCatcher_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (enableLogStash) {
					runStat.log(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_1", "tLogRow");
					talendJobLogProcess(globalMap);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tStatCatcher_1 begin ] start
				 */

				ok_Hash.put("tStatCatcher_1", false);
				start_Hash.put("tStatCatcher_1", System.currentTimeMillis());

				currentComponent = "tStatCatcher_1";

				int tos_count_tStatCatcher_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tStatCatcher_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tStatCatcher_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tStatCatcher_1 = new StringBuilder();
							log4jParamters_tStatCatcher_1.append("Parameters:");
							if (log.isDebugEnabled())
								log.debug("tStatCatcher_1 - " + (log4jParamters_tStatCatcher_1));
						}
					}
					new BytesLimit65535_tStatCatcher_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tStatCatcher_1", "tStatCatcher");
					talendJobLogProcess(globalMap);
				}

				for (StatCatcherUtils.StatCatcherMessage scm : tStatCatcher_1.getMessages()) {
					row3.pid = pid;
					row3.root_pid = rootPid;
					row3.father_pid = fatherPid;
					row3.project = projectName;
					row3.job = jobName;
					row3.context = contextStr;
					row3.origin = (scm.getOrigin() == null || scm.getOrigin().length() < 1 ? null : scm.getOrigin());
					row3.message = scm.getMessage();
					row3.duration = scm.getDuration();
					row3.moment = scm.getMoment();
					row3.message_type = scm.getMessageType();
					row3.job_version = scm.getJobVersion();
					row3.job_repository_id = scm.getJobId();
					row3.system_pid = scm.getSystemPid();

					/**
					 * [tStatCatcher_1 begin ] stop
					 */

					/**
					 * [tStatCatcher_1 main ] start
					 */

					currentComponent = "tStatCatcher_1";

					tos_count_tStatCatcher_1++;

					/**
					 * [tStatCatcher_1 main ] stop
					 */

					/**
					 * [tStatCatcher_1 process_data_begin ] start
					 */

					currentComponent = "tStatCatcher_1";

					/**
					 * [tStatCatcher_1 process_data_begin ] stop
					 */

					/**
					 * [tLogRow_1 main ] start
					 */

					currentComponent = "tLogRow_1";

					if (enableLogStash) {
						runStat.log(iterateId, 1, 1, "row3");
					}

					if (log.isTraceEnabled()) {
						log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
					}

///////////////////////		

					strBuffer_tLogRow_1 = new StringBuilder();

					if (row3.moment != null) { //

						strBuffer_tLogRow_1.append(FormatterUtils.format_Date(row3.moment, "yyyy-MM-dd HH:mm:ss"));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.pid != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.pid));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.father_pid != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.father_pid));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.root_pid != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.root_pid));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.system_pid != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.system_pid));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.project != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.project));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.job != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.job));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.job_repository_id != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.job_repository_id));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.job_version != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.job_version));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.context != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.context));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.origin != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.origin));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.message_type != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.message_type));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.message != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.message));

					} //

					strBuffer_tLogRow_1.append("|");

					if (row3.duration != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row3.duration));

					} //

					if (globalMap.get("tLogRow_CONSOLE") != null) {
						consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
					} else {
						consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
						globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
					}
					log.info("tLogRow_1 - Content of row " + (nb_line_tLogRow_1 + 1) + ": "
							+ strBuffer_tLogRow_1.toString());
					consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
					consoleOut_tLogRow_1.flush();
					nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

					tos_count_tLogRow_1++;

					/**
					 * [tLogRow_1 main ] stop
					 */

					/**
					 * [tLogRow_1 process_data_begin ] start
					 */

					currentComponent = "tLogRow_1";

					/**
					 * [tLogRow_1 process_data_begin ] stop
					 */

					/**
					 * [tLogRow_1 process_data_end ] start
					 */

					currentComponent = "tLogRow_1";

					/**
					 * [tLogRow_1 process_data_end ] stop
					 */

					/**
					 * [tStatCatcher_1 process_data_end ] start
					 */

					currentComponent = "tStatCatcher_1";

					/**
					 * [tStatCatcher_1 process_data_end ] stop
					 */

					/**
					 * [tStatCatcher_1 end ] start
					 */

					currentComponent = "tStatCatcher_1";

				}

				if (log.isDebugEnabled())
					log.debug("tStatCatcher_1 - " + ("Done."));

				ok_Hash.put("tStatCatcher_1", true);
				end_Hash.put("tStatCatcher_1", System.currentTimeMillis());

				/**
				 * [tStatCatcher_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (enableLogStash) {

					if (runStat.log(resourceMap, iterateId, "row3", 2, 0, talendJobLog, "tStatCatcher_1",
							"tStatCatcher", "tLogRow_1", "tLogRow", "output")) {
						talendJobLogProcess(globalMap);
					}

				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tStatCatcher_1 finally ] start
				 */

				currentComponent = "tStatCatcher_1";

				/**
				 * [tStatCatcher_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tStatCatcher_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.logging.audit.Context log_context_talendJobLog = null;
					if (jcm.component_name == null) {// job level log
						if (jcm.status == null) {// job start
							log_context_talendJobLog = org.talend.job.audit.JobContextBuilder.create()
									.jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
									.timestamp(jcm.moment).build();
							auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
						} else {// job end
							long timeMS = jcm.end_time - jcm.start_time;
							String duration = String.format(java.util.Locale.US, "%1$.2fs", (timeMS * 1.0) / 1000);

							log_context_talendJobLog = org.talend.job.audit.JobContextBuilder.create()
									.jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
									.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
							auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
						}
					} else if (jcm.current_connector == null) {// component log
						log_context_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name)
								.jobId(jcm.job_id).jobVersion(jcm.job_version).connectorType(jcm.component_name)
								.connectorId(jcm.component_id).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else {// component connector meter log
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.format(java.util.Locale.US, "%1$.2fs", (timeMS * 1.0) / 1000);

						if (jcm.current_connector_as_input) {// log current component input line
							log_context_talendJobLog = org.talend.job.audit.JobContextBuilder.create()
									.jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
									.connectorType(jcm.component_name).connectorId(jcm.component_id)
									.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
									.rows(jcm.total_row_number).duration(duration).build();
							auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
						} else {// log current component output/reject line
							log_context_talendJobLog = org.talend.job.audit.JobContextBuilder.create()
									.jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
									.connectorType(jcm.component_name).connectorId(jcm.component_id)
									.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
									.rows(jcm.total_row_number).duration(duration).build();
							auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
						}
					}
				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final createClient_API createClient_APIClass = new createClient_API();

		int exitCode = createClient_APIClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'createClient_API' - Done.");
		}

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("monitoring"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}
		log.info("TalendJob: 'createClient_API' - Start.");

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("monitoring.audit.logger.properties."))
					.forEach(key -> properties_talendJobLog.setProperty(
							key.substring("monitoring.audit.logger.properties.".length()), System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator.setLevel("audit", org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = createClient_API.class.getClassLoader()
					.getResourceAsStream("local_project/createclient_api_1_0/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = createClient_API.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				// defaultProps is in order to keep the original context value
				if (context != null && context.isEmpty()) {
					defaultProps.load(inContext);
					context = new ContextProperties(defaultProps);
				}

				inContext.close();
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();
		tStatCatcher_1.addMessage("begin");

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		try {
			tStatCatcher_1Process(globalMap);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRESTClient_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTClient_1) {
			globalMap.put("tRESTClient_1_SUBPROCESS_STATE", -1);

			e_tRESTClient_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		try {
			errorCode = null;
			tPostjob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPostjob_1) {
			globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

			e_tPostjob_1.printStackTrace();

		}

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : createClient_API");
		}
		tStatCatcher_1.addMessage(status == "" ? "end" : status, (end - startTime));
		try {
			tStatCatcher_1Process(globalMap);
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--monitoring") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 133434 characters generated by Talend Data Management Platform on the 12 de
 * Novembro de 2023 15h53min32s GMT
 ************************************************************************************************/