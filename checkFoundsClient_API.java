
package local_project.checkfoundsclient_api_1_0;

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
 * Job: checkFoundsClient_API Purpose: <br>
 * Description: <br>
 * 
 * @author luiz.honorato@outlook.com
 * @version 7.3.1.20200219_1130
 * @status
 */
public class checkFoundsClient_API implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "checkFoundsClient_API.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(checkFoundsClient_API.class);

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
	private final String jobName = "checkFoundsClient_API";
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

	StatCatcherUtils tStatCatcher_1 = new StatCatcherUtils("_l-FaUIFMEe6osYQNKL18nA", "1.0");
	JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_l-FaUIFMEe6osYQNKL18nA", "1.0");
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
					checkFoundsClient_API.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(checkFoundsClient_API.this, new Object[] { e, currentComponent, globalMap });
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

	public void tFlowToIterate_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
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

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_1_onSubJobError(exception, errorComponent, globalMap);
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

	public static class out_restresponseStruct implements routines.system.IPersistableRow<out_restresponseStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

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
		public int compareTo(out_restresponseStruct other) {

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

	public static class out_checkfoundsStruct implements routines.system.IPersistableRow<out_checkfoundsStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public String accountId;

		public String getAccountId() {
			return this.accountId;
		}

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
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

				try {

					int length = 0;

					this.accountId = readString(dis);

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

				writeString(this.accountId, dos);

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
			sb.append("accountId=" + accountId);
			sb.append(",clientDoc=" + clientDoc);
			sb.append(",clientName=" + clientName);
			sb.append(",value=" + String.valueOf(value));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (accountId == null) {
				sb.append("<null>");
			} else {
				sb.append(accountId);
			}

			sb.append("|");

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
		public int compareTo(out_checkfoundsStruct other) {

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

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public String idClient;

		public String getIdClient() {
			return this.idClient;
		}

		public String account;

		public String getAccount() {
			return this.account;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

				try {

					int length = 0;

					this.idClient = readString(dis);

					this.account = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.idClient, dos);

				// String

				writeString(this.account, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("idClient=" + idClient);
			sb.append(",account=" + account);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (idClient == null) {
				sb.append("<null>");
			} else {
				sb.append(idClient);
			}

			sb.append("|");

			if (account == null) {
				sb.append("<null>");
			} else {
				sb.append(account);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

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

	public static class outSqlCreateStruct implements routines.system.IPersistableRow<outSqlCreateStruct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public String clientDoc;

		public String getClientDoc() {
			return this.clientDoc;
		}

		public String clientName;

		public String getClientName() {
			return this.clientName;
		}

		public BigDecimal initialValue;

		public BigDecimal getInitialValue() {
			return this.initialValue;
		}

		public String account;

		public String getAccount() {
			return this.account;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

				try {

					int length = 0;

					this.clientDoc = readString(dis);

					this.clientName = readString(dis);

					this.initialValue = (BigDecimal) dis.readObject();

					this.account = readString(dis);

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

				dos.writeObject(this.initialValue);

				// String

				writeString(this.account, dos);

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
			sb.append(",initialValue=" + String.valueOf(initialValue));
			sb.append(",account=" + account);
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

			if (initialValue == null) {
				sb.append("<null>");
			} else {
				sb.append(initialValue);
			}

			sb.append("|");

			if (account == null) {
				sb.append("<null>");
			} else {
				sb.append(account);
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
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

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
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

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
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

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

	public static class after_tRESTClient_1Struct
			implements routines.system.IPersistableRow<after_tRESTClient_1Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public String string;

		public String getString() {
			return this.string;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

				try {

					int length = 0;

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
			sb.append("body=" + String.valueOf(body));
			sb.append(",string=" + string);
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
		public int compareTo(after_tRESTClient_1Struct other) {

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

				tDBInput_1Process(globalMap);

				row1Struct row1 = new row1Struct();
				row2Struct row2 = new row2Struct();
				outSqlCreateStruct outSqlCreate = new outSqlCreateStruct();
				row4Struct row4 = new row4Struct();
				out_checkfoundsStruct out_checkfounds = new out_checkfoundsStruct();
				out_restresponseStruct out_restresponse = new out_restresponseStruct();

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
					webClient_tRESTClient_1.path("/checkfounds");

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

								synchronized (checkFoundsClient_API.this.obj) {

									super.put(key, value);
									return checkFoundsClient_API.this.globalMap.put(key, value);

								}

							}
						}

						private java.util.Map<String, Object> globalMap = null;
						boolean isRunning = false;
						String iterateId = "";

						row1Struct row1 = new row1Struct();
						row2Struct row2 = new row2Struct();
						outSqlCreateStruct outSqlCreate = new outSqlCreateStruct();
						row4Struct row4 = new row4Struct();
						out_checkfoundsStruct out_checkfounds = new out_checkfoundsStruct();
						out_restresponseStruct out_restresponse = new out_restresponseStruct();

						public tFixedFlowInput_1Thread(java.util.Map<String, Object> globalMap, row1Struct row1,
								row2Struct row2, outSqlCreateStruct outSqlCreate, row4Struct row4,
								out_checkfoundsStruct out_checkfounds, out_restresponseStruct out_restresponse,
								int threadID) {
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

								this.outSqlCreate.initialValue = outSqlCreate.initialValue;

								this.outSqlCreate.account = outSqlCreate.account;

							}

							if (row4 != null) {

								this.row4.idClient = row4.idClient;

								this.row4.account = row4.account;

							}

							if (out_checkfounds != null) {

								this.out_checkfounds.accountId = out_checkfounds.accountId;

								this.out_checkfounds.clientDoc = out_checkfounds.clientDoc;

								this.out_checkfounds.clientName = out_checkfounds.clientName;

								this.out_checkfounds.value = out_checkfounds.value;

							}

							if (out_restresponse != null) {

								this.out_restresponse.body = out_restresponse.body;

							}

							synchronized (checkFoundsClient_API.this.obj) {
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

									String[] absolutePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[4];
									String[] relativePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[4];

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "row2.body:/root/account";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "account";

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "row2.body:/root/clientName";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "clientName";

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[2] = "row2.body:/root/initialValue";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[2] = "initialValue";

									absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[3] = "row2.body:/root/clientDoc";
									relativePathMappings_tXMLMap_1_TXMLMAP_OUT[3] = "clientDoc";

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
											outSqlCreate_tmp.initialValue = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
													.get_BigDecimal("row2.body:/root/initialValue");
											outSqlCreate_tmp.account = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
													.get_String("row2.body:/root/account");
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
								 * [tFlowToIterate_2 begin ] start
								 */

								int NB_ITERATE_tFixedFlowInput_2 = 0; // for statistics

								ok_Hash.put("tFlowToIterate_2", false);
								start_Hash.put("tFlowToIterate_2", System.currentTimeMillis());

								currentComponent = "tFlowToIterate_2";

								if (enableLogStash) {
									runStat.log(resourceMap, iterateId, 0, 0, "outSqlCreate");
								}

								int tos_count_tFlowToIterate_2 = 0;

								if (log.isDebugEnabled())
									log.debug("tFlowToIterate_2 - " + ("Start to work."));
								if (log.isDebugEnabled()) {
									class BytesLimit65535_tFlowToIterate_2 {
										public void limitLog4jByte() throws Exception {
											StringBuilder log4jParamters_tFlowToIterate_2 = new StringBuilder();
											log4jParamters_tFlowToIterate_2.append("Parameters:");
											log4jParamters_tFlowToIterate_2.append("DEFAULT_MAP" + " = " + "false");
											log4jParamters_tFlowToIterate_2.append(" | ");
											log4jParamters_tFlowToIterate_2.append("MAP" + " = " + "[{VALUE="
													+ ("clientDoc") + ", KEY=" + ("\"clientDoc\"") + "}, {VALUE="
													+ ("account") + ", KEY=" + ("\"account\"") + "}]");
											log4jParamters_tFlowToIterate_2.append(" | ");
											if (log.isDebugEnabled())
												log.debug("tFlowToIterate_2 - " + (log4jParamters_tFlowToIterate_2));
										}
									}
									new BytesLimit65535_tFlowToIterate_2().limitLog4jByte();
								}
								if (enableLogStash) {
									talendJobLog.addCM("tFlowToIterate_2", "tFlowToIterate");
									talendJobLogProcess(globalMap);
								}

								int nb_line_tFlowToIterate_2 = 0;
								int counter_tFlowToIterate_2 = 0;

								/**
								 * [tFlowToIterate_2 begin ] stop
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
										 * [tFlowToIterate_2 main ] start
										 */

										currentComponent = "tFlowToIterate_2";

										if (enableLogStash) {
											runStat.log(iterateId, 1, 1, "outSqlCreate");
										}

										if (log.isTraceEnabled()) {
											log.trace("outSqlCreate - "
													+ (outSqlCreate == null ? "" : outSqlCreate.toLogString()));
										}

										if (log.isTraceEnabled())
											log.trace("tFlowToIterate_2 - " + ("Set global var, key=") + ("clientDoc")
													+ (", value=") + (outSqlCreate.clientDoc) + ("."));
										globalMap.put("clientDoc", outSqlCreate.clientDoc);
										if (log.isTraceEnabled())
											log.trace("tFlowToIterate_2 - " + ("Set global var, key=") + ("account")
													+ (", value=") + (outSqlCreate.account) + ("."));
										globalMap.put("account", outSqlCreate.account);
										nb_line_tFlowToIterate_2++;
										counter_tFlowToIterate_2++;
										if (log.isDebugEnabled())
											log.debug("tFlowToIterate_2 - " + ("Current iteration is: ")
													+ (counter_tFlowToIterate_2) + ("."));
										globalMap.put("tFlowToIterate_2_CURRENT_ITERATION", counter_tFlowToIterate_2);

										tos_count_tFlowToIterate_2++;

										/**
										 * [tFlowToIterate_2 main ] stop
										 */

										/**
										 * [tFlowToIterate_2 process_data_begin ] start
										 */

										currentComponent = "tFlowToIterate_2";

										/**
										 * [tFlowToIterate_2 process_data_begin ] stop
										 */
										NB_ITERATE_tFixedFlowInput_2++;

										/**
										 * [tRESTClient_2 begin ] start
										 */

										ok_Hash.put("tRESTClient_2", false);
										start_Hash.put("tRESTClient_2", System.currentTimeMillis());

										currentComponent = "tRESTClient_2";

										if (enableLogStash) {
											runStat.log(resourceMap, iterateId, 0, 0, "out_restresponse");
										}

										int tos_count_tRESTClient_2 = 0;

										if (enableLogStash) {
											talendJobLog.addCM("tRESTClient_2", "tRESTClient");
											talendJobLogProcess(globalMap);
										}

										/**
										 * [tRESTClient_2 begin ] stop
										 */

										/**
										 * [tXMLMap_2 begin ] start
										 */

										ok_Hash.put("tXMLMap_2", false);
										start_Hash.put("tXMLMap_2", System.currentTimeMillis());

										currentComponent = "tXMLMap_2";

										if (enableLogStash) {
											runStat.log(resourceMap, iterateId, 0, 0, "out_checkfounds");
										}

										int tos_count_tXMLMap_2 = 0;

										if (log.isDebugEnabled())
											log.debug("tXMLMap_2 - " + ("Start to work."));
										if (log.isDebugEnabled()) {
											class BytesLimit65535_tXMLMap_2 {
												public void limitLog4jByte() throws Exception {
													StringBuilder log4jParamters_tXMLMap_2 = new StringBuilder();
													log4jParamters_tXMLMap_2.append("Parameters:");
													log4jParamters_tXMLMap_2
															.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
													log4jParamters_tXMLMap_2.append(" | ");
													if (log.isDebugEnabled())
														log.debug("tXMLMap_2 - " + (log4jParamters_tXMLMap_2));
												}
											}
											new BytesLimit65535_tXMLMap_2().limitLog4jByte();
										}
										if (enableLogStash) {
											talendJobLog.addCM("tXMLMap_2", "tXMLMap");
											talendJobLogProcess(globalMap);
										}

//===============================input xml init part===============================
										class XML_API_tXMLMap_2 {
											public boolean isDefNull(org.dom4j.Node node)
													throws javax.xml.transform.TransformerException {
												if (node != null && node instanceof org.dom4j.Element) {
													org.dom4j.Attribute attri = ((org.dom4j.Element) node)
															.attribute("nil");
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
										class Var__tXMLMap_2__Struct {
										}
										Var__tXMLMap_2__Struct Var__tXMLMap_2 = new Var__tXMLMap_2__Struct();
// ###############################
// # Outputs initialization
										out_restresponseStruct out_restresponse_tmp = new out_restresponseStruct();
										out_restresponseStruct out_restresponse_save = null;
										int count_out_restresponse_tXMLMap_2 = 0;
// ###############################
										int nb_line_tXMLMap_2 = 0;

										XML_API_tXMLMap_2 xml_api_tXMLMap_2 = new XML_API_tXMLMap_2();

										class GenerateDocument_out_restresponse {

											java.util.Map<String, Object> valueMap = null;

											routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(
													1);

											org.dom4j.Document doc = null;

											org.dom4j.Element root4Group = null;

											org.dom4j.io.OutputFormat format = null;

											java.util.List<java.util.List<String>> groupbyList = null;
											java.util.List<org.dom4j.Element> groupElementList = null;
											int order = 0;

											boolean isFirst = true;

											boolean needRoot = true;

											String currentValue = null;

											public GenerateDocument_out_restresponse() {
//    	this.treeNodeAPI = treeNodeAPI;

												valueMap = new java.util.HashMap<String, Object>();

												groupbyList = new java.util.ArrayList<java.util.List<String>>();
												groupElementList = new java.util.ArrayList<org.dom4j.Element>();

												doc = org.dom4j.DocumentHelper.createDocument();
												format = org.dom4j.io.OutputFormat.createPrettyPrint();
												format.setTrimText(false);
											}

											public org.dom4j.Document getDocument() {
												generateOk();
												return this.doc;
											}

											// do some work after document has been generated
											private void generateOk() {
												routines.system.NestXMLTool
														.replaceDefaultNameSpace(this.doc.getRootElement(), null);
											}

											// We generate the TreeNode_API object only if there is a document in the
											// main input table.
											void generateElements(boolean isInnerJoin,
													out_checkfoundsStruct out_checkfounds, Var__tXMLMap_2__Struct Var) {

												/*
												 * if(this.treeNodeAPI==null) { this.treeNodeAPI = treeNodeAPI; }
												 */

												org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
												if (needRoot) {
													needRoot = false;
													org.dom4j.Element root = null;
													root = org.dom4j.DocumentHelper.createElement("root");
													doc.add(root);
													subTreeRootParent = root;
													org.dom4j.Element root_0 = null;
													root_0 = root.addElement("accountId");
													valueMap.put("root_0", out_checkfounds.accountId);
													if (valueMap.get("root_0") != null) {
														routines.system.NestXMLTool.setText(root_0,
																FormatterUtils.fm(valueMap.get("root_0"), null));
													}
													org.dom4j.Element root_1 = null;
													root_1 = root.addElement("clientDoc");
													valueMap.put("root_1", out_checkfounds.clientDoc);
													if (valueMap.get("root_1") != null) {
														routines.system.NestXMLTool.setText(root_1,
																FormatterUtils.fm(valueMap.get("root_1"), null));
													}
													org.dom4j.Element root_2 = null;
													root_2 = root.addElement("clientName");
													valueMap.put("root_2", out_checkfounds.clientName);
													if (valueMap.get("root_2") != null) {
														routines.system.NestXMLTool.setText(root_2,
																FormatterUtils.fm(valueMap.get("root_2"), null));
													}
													org.dom4j.Element root_3 = null;
													root_3 = root.addElement("value");
													valueMap.put("root_3", out_checkfounds.value);
													if (valueMap.get("root_3") != null) {
														routines.system.NestXMLTool.setText(root_3,
																FormatterUtils.fm(valueMap.get("root_3"), null));
													}
													root4Group = subTreeRootParent;
												} else {
													subTreeRootParent = root4Group;
												}
												/* build group xml tree */
												boolean isNewElement = false;
												isNewElement = false;
											}
										}

										/**
										 * [tXMLMap_2 begin ] stop
										 */

										/**
										 * [tMap_1 begin ] start
										 */

										ok_Hash.put("tMap_1", false);
										start_Hash.put("tMap_1", System.currentTimeMillis());

										currentComponent = "tMap_1";

										if (enableLogStash) {
											runStat.log(resourceMap, iterateId, 0, 0, "row4");
										}

										int tos_count_tMap_1 = 0;

										if (log.isDebugEnabled())
											log.debug("tMap_1 - " + ("Start to work."));
										if (log.isDebugEnabled()) {
											class BytesLimit65535_tMap_1 {
												public void limitLog4jByte() throws Exception {
													StringBuilder log4jParamters_tMap_1 = new StringBuilder();
													log4jParamters_tMap_1.append("Parameters:");
													log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
													log4jParamters_tMap_1.append(" | ");
													log4jParamters_tMap_1
															.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
													log4jParamters_tMap_1.append(" | ");
													log4jParamters_tMap_1
															.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
													log4jParamters_tMap_1.append(" | ");
													log4jParamters_tMap_1.append(
															"CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
													log4jParamters_tMap_1.append(" | ");
													if (log.isDebugEnabled())
														log.debug("tMap_1 - " + (log4jParamters_tMap_1));
												}
											}
											new BytesLimit65535_tMap_1().limitLog4jByte();
										}
										if (enableLogStash) {
											talendJobLog.addCM("tMap_1", "tMap");
											talendJobLogProcess(globalMap);
										}

// ###############################
// # Lookup's keys initialization

										Integer currentThreadNumber_tMap_1 = null;

										synchronized (checkFoundsClient_API.this.obj) {

											currentThreadNumber_tMap_1 = (Integer) checkFoundsClient_API.this.globalMap
													.get("currentThreadNumber_tMap_1");

											if (currentThreadNumber_tMap_1 == null) {
												currentThreadNumber_tMap_1 = 1;
											} else {
												currentThreadNumber_tMap_1++;
											}
											checkFoundsClient_API.this.globalMap.put("currentThreadNumber_tMap_1",
													currentThreadNumber_tMap_1);

										}
										int count_row4_tMap_1 = 0;

										int count_row5_tMap_1 = 0;

										org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) globalMap
												.get("tHash_Lookup_row5"))

														.clone();

										row5Struct row5HashKey = new row5Struct();
										row5Struct row5Default = new row5Struct();
// ###############################        

// ###############################
// # Vars initialization
										class Var__tMap_1__Struct {
										}
										Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
										int count_out_checkfounds_tMap_1 = 0;

										out_checkfoundsStruct out_checkfounds_tmp = new out_checkfoundsStruct();
// ###############################

										/**
										 * [tMap_1 begin ] stop
										 */

										/**
										 * [tFixedFlowInput_2 begin ] start
										 */

										ok_Hash.put("tFixedFlowInput_2", false);
										start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

										currentComponent = "tFixedFlowInput_2";

										int tos_count_tFixedFlowInput_2 = 0;

										if (enableLogStash) {
											talendJobLog.addCM("tFixedFlowInput_2", "tFixedFlowInput");
											talendJobLogProcess(globalMap);
										}

										for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

											row4.idClient = ((String) globalMap.get("clientDoc"));

											row4.account = null;

											/**
											 * [tFixedFlowInput_2 begin ] stop
											 */

											/**
											 * [tFixedFlowInput_2 main ] start
											 */

											currentComponent = "tFixedFlowInput_2";

											tos_count_tFixedFlowInput_2++;

											/**
											 * [tFixedFlowInput_2 main ] stop
											 */

											/**
											 * [tFixedFlowInput_2 process_data_begin ] start
											 */

											currentComponent = "tFixedFlowInput_2";

											/**
											 * [tFixedFlowInput_2 process_data_begin ] stop
											 */

											/**
											 * [tMap_1 main ] start
											 */

											currentComponent = "tMap_1";

											if (enableLogStash) {
												runStat.log(iterateId, 1, 1, "row4");
											}

											if (log.isTraceEnabled()) {
												log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
											}

											boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

											// ###############################
											// # Input tables (lookups)
											boolean rejectedInnerJoin_tMap_1 = false;
											boolean mainRowRejected_tMap_1 = false;

											///////////////////////////////////////////////
											// Starting Lookup Table "row5"
											///////////////////////////////////////////////

											boolean forceLooprow5 = false;

											row5Struct row5ObjectFromLookup = null;

											if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

												hasCasePrimitiveKeyWithNull_tMap_1 = false;

												row5HashKey.clientDoc = row4.idClient;

												row5HashKey.accountId = row4.account;

												row5HashKey.hashCodeDirty = true;

												tHash_Lookup_row5.lookup(row5HashKey);

												if (!tHash_Lookup_row5.hasNext()) { // G_TM_M_090

													rejectedInnerJoin_tMap_1 = true;

												} // G_TM_M_090

											} // G_TM_M_020

											if (tHash_Lookup_row5 != null
													&& tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

												// System.out.println("WARNING: UNIQUE MATCH is configured for the
												// lookup 'row5' and it contains more one result from keys :
												// row5.clientDoc = '" + row5HashKey.clientDoc + "', row5.accountId = '"
												// + row5HashKey.accountId + "'");
											} // G 071

											row5Struct row5 = null;

											row5Struct fromLookup_row5 = null;
											row5 = row5Default;

											if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

												fromLookup_row5 = tHash_Lookup_row5.next();

											} // G 099

											if (fromLookup_row5 != null) {
												row5 = fromLookup_row5;
											}

											// ###############################
											{ // start of Var scope

												// ###############################
												// # Vars tables

												Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
												// ###############################
												// # Output tables

												out_checkfounds = null;

												if (!rejectedInnerJoin_tMap_1) {

// # Output table : 'out_checkfounds'
													count_out_checkfounds_tMap_1++;

													out_checkfounds_tmp.accountId = row5.accountId;
													out_checkfounds_tmp.clientDoc = row5.clientDoc;
													out_checkfounds_tmp.clientName = row5.clientName;
													out_checkfounds_tmp.value = row5.value;
													out_checkfounds = out_checkfounds_tmp;
													log.debug("tMap_1 - Outputting the record "
															+ count_out_checkfounds_tMap_1
															+ " of the output table 'out_checkfounds'.");

												} // closing inner join bracket (2)
// ###############################

											} // end of Var scope

											rejectedInnerJoin_tMap_1 = false;

											tos_count_tMap_1++;

											/**
											 * [tMap_1 main ] stop
											 */

											/**
											 * [tMap_1 process_data_begin ] start
											 */

											currentComponent = "tMap_1";

											/**
											 * [tMap_1 process_data_begin ] stop
											 */
// Start of branch "out_checkfounds"
											if (out_checkfounds != null) {

												/**
												 * [tXMLMap_2 main ] start
												 */

												currentComponent = "tXMLMap_2";

												if (enableLogStash) {
													runStat.log(iterateId, 1, 1, "out_checkfounds");
												}

												if (log.isTraceEnabled()) {
													log.trace("out_checkfounds - " + (out_checkfounds == null ? ""
															: out_checkfounds.toLogString()));
												}

												boolean rejectedInnerJoin_tXMLMap_2 = false;
												boolean rejectedDocInnerJoin_tXMLMap_2 = false;
												boolean mainRowRejected_tXMLMap_2 = false;
												boolean isMatchDocRowtXMLMap_2 = false;

												GenerateDocument_out_restresponse gen_Doc_out_restresponse_tXMLMap_2 = new GenerateDocument_out_restresponse();
												out_restresponse_tmp.body = null;

												{ // start of Var scope

													// ###############################
													// # Vars tables

													Var__tXMLMap_2__Struct Var = Var__tXMLMap_2;
													// ###############################
													// # Output tables

													out_restresponse = null;

// # Output table : 'out_restresponse'
													count_out_restresponse_tXMLMap_2++;

													gen_Doc_out_restresponse_tXMLMap_2.generateElements(
															rejectedDocInnerJoin_tXMLMap_2, out_checkfounds, Var);

													if (out_restresponse_tmp.body == null) {
														out_restresponse_tmp.body = new routines.system.Document();
														out_restresponse_tmp.body.setDocument(
																gen_Doc_out_restresponse_tXMLMap_2.getDocument());
													}

													out_restresponse = out_restresponse_tmp;
													out_restresponse_save = out_restresponse_tmp;
													log.debug("tXMLMap_2 - Outputting the record "
															+ count_out_restresponse_tXMLMap_2
															+ " of the output table 'out_restresponse'.");

// ###############################

												} // end of Var scope

												rejectedInnerJoin_tXMLMap_2 = false;

												tos_count_tXMLMap_2++;

												/**
												 * [tXMLMap_2 main ] stop
												 */

												/**
												 * [tXMLMap_2 process_data_begin ] start
												 */

												currentComponent = "tXMLMap_2";

												/**
												 * [tXMLMap_2 process_data_begin ] stop
												 */
// Start of branch "out_restresponse"
												if (out_restresponse != null) {

													/**
													 * [tRESTClient_2 main ] start
													 */

													currentComponent = "tRESTClient_2";

													if (enableLogStash) {
														runStat.log(iterateId, 1, 1, "out_restresponse");
													}

													if (log.isTraceEnabled()) {
														log.trace("out_restresponse - " + (out_restresponse == null ? ""
																: out_restresponse.toLogString()));
													}

// expected response body
													Object responseDoc_tRESTClient_2 = null;

													try {
														// request body
														org.dom4j.Document requestDoc_tRESTClient_2 = null;
														String requestString_tRESTClient_2 = null;
														if (null != out_restresponse.body) {
															requestDoc_tRESTClient_2 = out_restresponse.body
																	.getDocument();
														}

														Object requestBody_tRESTClient_2 = requestDoc_tRESTClient_2 != null
																? requestDoc_tRESTClient_2
																: requestString_tRESTClient_2;

														// resposne class name
														Class<?> responseClass_tRESTClient_2 = org.dom4j.Document.class;

														// create web client instance
														org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_2 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

														boolean inOSGi = routines.system.BundleUtils.inOSGi();

														final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_2 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

														String url = "www.testLuizEquadis";
														// {baseUri}tRESTClient
														factoryBean_tRESTClient_2.setServiceName(
																new javax.xml.namespace.QName(url, "tRESTClient"));
														factoryBean_tRESTClient_2.setAddress(url);

														factoryBean_tRESTClient_2.setFeatures(features_tRESTClient_2);

														java.util.List<Object> providers_tRESTClient_2 = new java.util.ArrayList<Object>();
														providers_tRESTClient_2.add(
																new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
																	// workaround for
																	// https://jira.talendforge.org/browse/TESB-7276
																	public org.dom4j.Document readFrom(
																			Class<org.dom4j.Document> cls,
																			java.lang.reflect.Type type,
																			java.lang.annotation.Annotation[] anns,
																			javax.ws.rs.core.MediaType mt,
																			javax.ws.rs.core.MultivaluedMap<String, String> headers,
																			java.io.InputStream is) throws IOException,
																			javax.ws.rs.WebApplicationException {
																		String contentLength = headers
																				.getFirst("Content-Length");
																		if (!org.apache.cxf.common.util.StringUtils
																				.isEmpty(contentLength)
																				&& Integer
																						.valueOf(contentLength) <= 0) {
																			try {
																				return org.dom4j.DocumentHelper
																						.parseText("<root/>");
																			} catch (org.dom4j.DocumentException e_tRESTClient_2) {
																				e_tRESTClient_2.printStackTrace();
																			}
																			return null;
																		}
																		return super.readFrom(cls, type, anns, mt,
																				headers, is);
																	}
																});
														org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_2 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
														jsonProvider_tRESTClient_2.setIgnoreNamespaces(true);
														jsonProvider_tRESTClient_2.setAttributesToElements(true);

														jsonProvider_tRESTClient_2.setSupportUnwrapped(true);
														jsonProvider_tRESTClient_2.setWrapperName("root");

														jsonProvider_tRESTClient_2.setDropRootElement(false);
														jsonProvider_tRESTClient_2.setConvertTypesToStrings(false);
														providers_tRESTClient_2.add(jsonProvider_tRESTClient_2);
														factoryBean_tRESTClient_2.setProviders(providers_tRESTClient_2);
														factoryBean_tRESTClient_2.setTransportId(
																"http://cxf.apache.org/transports/http");

														boolean use_auth_tRESTClient_2 = false;

														org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_2 = factoryBean_tRESTClient_2
																.createWebClient();

														// set request path
														webClient_tRESTClient_2.path("/replycheckfounds");

														// set connection properties
														org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_2 = org.apache.cxf.jaxrs.client.WebClient
																.getConfig(webClient_tRESTClient_2);
														org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_2 = clientConfig_tRESTClient_2
																.getHttpConduit();

														if (clientConfig_tRESTClient_2.getEndpoint() != null
																&& clientConfig_tRESTClient_2.getEndpoint()
																		.getEndpointInfo() != null) {
															clientConfig_tRESTClient_2.getEndpoint().getEndpointInfo()
																	.setProperty("enable.webclient.operation.reporting",
																			true);
														}

														if (!inOSGi) {
															conduit_tRESTClient_2.getClient()
																	.setReceiveTimeout((long) (60 * 1000L));
															conduit_tRESTClient_2.getClient()
																	.setConnectionTimeout((long) (30 * 1000L));
															boolean use_proxy_tRESTClient_2 = false;

														}

														// set Accept-Type
														webClient_tRESTClient_2.accept("application/xml");

														// set optional query and header properties if any

														if (use_auth_tRESTClient_2 && "OAUTH2_BEARER".equals("BASIC")) {
															// set oAuth2 bearer token
															webClient_tRESTClient_2.header("Authorization",
																	"Bearer " + "");
														}

														// if FORM request then capture query parameters into Form,
														// otherwise set them as queries

														try {
															// start send request

															responseDoc_tRESTClient_2 = webClient_tRESTClient_2
																	.get(responseClass_tRESTClient_2);

															int webClientResponseStatus_tRESTClient_2 = webClient_tRESTClient_2
																	.getResponse().getStatus();
															if (webClientResponseStatus_tRESTClient_2 >= 300) {
																throw new javax.ws.rs.WebApplicationException(
																		webClient_tRESTClient_2.getResponse());
															}

														} catch (javax.ws.rs.WebApplicationException ex_tRESTClient_2) {

															throw ex_tRESTClient_2;

														}

													} catch (Exception e_tRESTClient_2) {

														throw new TalendException(e_tRESTClient_2, currentComponent,
																globalMap);

													}

													tos_count_tRESTClient_2++;

													/**
													 * [tRESTClient_2 main ] stop
													 */

													/**
													 * [tRESTClient_2 process_data_begin ] start
													 */

													currentComponent = "tRESTClient_2";

													/**
													 * [tRESTClient_2 process_data_begin ] stop
													 */

													/**
													 * [tRESTClient_2 process_data_end ] start
													 */

													currentComponent = "tRESTClient_2";

													/**
													 * [tRESTClient_2 process_data_end ] stop
													 */

												} // End of branch "out_restresponse"

												/**
												 * [tXMLMap_2 process_data_end ] start
												 */

												currentComponent = "tXMLMap_2";

												/**
												 * [tXMLMap_2 process_data_end ] stop
												 */

											} // End of branch "out_checkfounds"

											/**
											 * [tMap_1 process_data_end ] start
											 */

											currentComponent = "tMap_1";

											/**
											 * [tMap_1 process_data_end ] stop
											 */

											/**
											 * [tFixedFlowInput_2 process_data_end ] start
											 */

											currentComponent = "tFixedFlowInput_2";

											/**
											 * [tFixedFlowInput_2 process_data_end ] stop
											 */

											/**
											 * [tFixedFlowInput_2 end ] start
											 */

											currentComponent = "tFixedFlowInput_2";

										}
										globalMap.put("tFixedFlowInput_2_NB_LINE", 1);

										ok_Hash.put("tFixedFlowInput_2", true);
										end_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

										/**
										 * [tFixedFlowInput_2 end ] stop
										 */

										/**
										 * [tMap_1 end ] start
										 */

										currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
										log.debug("tMap_1 - Written records count in the table 'out_checkfounds': "
												+ count_out_checkfounds_tMap_1 + ".");

										if (enableLogStash) {

											if (runStat.log(resourceMap, iterateId, "row4", 2, 0, talendJobLog,
													"tFixedFlowInput_2", "tFixedFlowInput", "tMap_1", "tMap",
													"output")) {
												talendJobLogProcess(globalMap);
											}

										}

										if (log.isDebugEnabled())
											log.debug("tMap_1 - " + ("Done."));

										ok_Hash.put("tMap_1", true);
										end_Hash.put("tMap_1", System.currentTimeMillis());

										/**
										 * [tMap_1 end ] stop
										 */

										/**
										 * [tXMLMap_2 end ] start
										 */

										currentComponent = "tXMLMap_2";

										log.debug("tXMLMap_2 - Written records count in the table 'out_restresponse': "
												+ count_out_restresponse_tXMLMap_2 + ".");
										if (enableLogStash) {

											if (runStat.log(resourceMap, iterateId, "out_checkfounds", 2, 0,
													talendJobLog, "tMap_1", "tMap", "tXMLMap_2", "tXMLMap", "output")) {
												talendJobLogProcess(globalMap);
											}

										}

										if (log.isDebugEnabled())
											log.debug("tXMLMap_2 - " + ("Done."));

										ok_Hash.put("tXMLMap_2", true);
										end_Hash.put("tXMLMap_2", System.currentTimeMillis());

										/**
										 * [tXMLMap_2 end ] stop
										 */

										/**
										 * [tRESTClient_2 end ] start
										 */

										currentComponent = "tRESTClient_2";

										if (globalMap.get("tRESTClient_2_NB_LINE") == null) {
											globalMap.put("tRESTClient_2_NB_LINE", 1);
										}

// [tRESTCliend_end]
										if (enableLogStash) {

											if (runStat.log(resourceMap, iterateId, "out_restresponse", 2, 0,
													talendJobLog, "tXMLMap_2", "tXMLMap", "tRESTClient_2",
													"tRESTClient", "output")) {
												talendJobLogProcess(globalMap);
											}

										}

										ok_Hash.put("tRESTClient_2", true);
										end_Hash.put("tRESTClient_2", System.currentTimeMillis());

										/**
										 * [tRESTClient_2 end ] stop
										 */

										/**
										 * [tFlowToIterate_2 process_data_end ] start
										 */

										currentComponent = "tFlowToIterate_2";

										/**
										 * [tFlowToIterate_2 process_data_end ] stop
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
								 * [tFlowToIterate_2 end ] start
								 */

								currentComponent = "tFlowToIterate_2";

								globalMap.put("tFlowToIterate_2_NB_LINE", nb_line_tFlowToIterate_2);
								if (enableLogStash) {

									if (runStat.log(resourceMap, iterateId, "outSqlCreate", 2, 0, talendJobLog,
											"tXMLMap_1_TXMLMAP_IN", "tXMLMapIn", "tFlowToIterate_2", "tFlowToIterate",
											"output")) {
										talendJobLogProcess(globalMap);
									}

								}

								if (log.isDebugEnabled())
									log.debug("tFlowToIterate_2 - " + ("Done."));

								ok_Hash.put("tFlowToIterate_2", true);
								end_Hash.put("tFlowToIterate_2", System.currentTimeMillis());

								/**
								 * [tFlowToIterate_2 end ] stop
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
									 * [tFlowToIterate_2 finally ] start
									 */

									currentComponent = "tFlowToIterate_2";

									/**
									 * [tFlowToIterate_2 finally ] stop
									 */

									/**
									 * [tFixedFlowInput_2 finally ] start
									 */

									currentComponent = "tFixedFlowInput_2";

									/**
									 * [tFixedFlowInput_2 finally ] stop
									 */

									/**
									 * [tMap_1 finally ] start
									 */

									currentComponent = "tMap_1";

									/**
									 * [tMap_1 finally ] stop
									 */

									/**
									 * [tXMLMap_2 finally ] start
									 */

									currentComponent = "tXMLMap_2";

									/**
									 * [tXMLMap_2 finally ] stop
									 */

									/**
									 * [tRESTClient_2 finally ] start
									 */

									currentComponent = "tRESTClient_2";

									/**
									 * [tRESTClient_2 finally ] stop
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
							outSqlCreate, row4, out_checkfounds, out_restresponse, threadIdCounter_tFixedFlowInput_1++);
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

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row5");

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

	public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

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

		public String accountId;

		public String getAccountId() {
			return this.accountId;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.clientDoc == null) ? 0 : this.clientDoc.hashCode());

				result = prime * result + ((this.accountId == null) ? 0 : this.accountId.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row5Struct other = (row5Struct) obj;

			if (this.clientDoc == null) {
				if (other.clientDoc != null)
					return false;

			} else if (!this.clientDoc.equals(other.clientDoc))

				return false;

			if (this.accountId == null) {
				if (other.accountId != null)
					return false;

			} else if (!this.accountId.equals(other.accountId))

				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.clientDoc = this.clientDoc;
			other.clientName = this.clientName;
			other.value = this.value;
			other.accountId = this.accountId;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.clientDoc = this.clientDoc;
			other.accountId = this.accountId;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

				try {

					int length = 0;

					this.clientDoc = readString(dis);

					this.accountId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.clientDoc, dos);

				// String

				writeString(this.accountId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.clientName = readString(dis, ois);

				this.value = (BigDecimal) ois.readObject();

			} catch (IOException e) {
				throw new RuntimeException(e);

			} catch (ClassNotFoundException eCNFE) {
				throw new RuntimeException(eCNFE);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.clientName, dos, oos);

				oos.writeObject(this.value);

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
			sb.append(",accountId=" + accountId);
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

			if (accountId == null) {
				sb.append("<null>");
			} else {
				sb.append(accountId);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.clientDoc, other.clientDoc);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.accountId, other.accountId);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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

				row5Struct row5 = new row5Struct();

				/**
				 * [tAdvancedHash_row5 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row5", false);
				start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row5";

				if (enableLogStash) {
					runStat.log(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tAdvancedHash_row5 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAdvancedHash_row5", "tAdvancedHash");
					talendJobLogProcess(globalMap);
				}

				// connection name:row5
				// source node:tDBInput_1 - inputs:(after_tRESTClient_1) outputs:(row5,row5) |
				// target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
				// linked node: tMap_1 - inputs:(row4,row5) outputs:(out_checkfounds)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row5Struct>getLookup(matchingModeEnum_row5);

				globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);

				/**
				 * [tAdvancedHash_row5 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = " + "\"testequadis\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DRIVER" + " = " + "JTDS");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "\"1433\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DB_SCHEMA" + " = " + "\"testequadis\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"testequadis\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "\"testequadis\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PASS" + " = "
									+ String.valueOf(
											"enc:routine.encryption.key.v1:o+mpc+FtFYpzJT3TNf8nWwOBxAcO9DKylOv5eQ==")
											.substring(0, 4)
									+ "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"select   clientDoc,  clientName,  value,  accountId  fromtestequadis\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("clientDoc") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("clientName") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("value")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("accountId") + "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_1", "tMSSqlInput");
					talendJobLogProcess(globalMap);
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "testequadis";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:e4Vdz+vpY0XPqJXbPjTcK3vHAWZSf6rPlt2h5w==");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "testequadis";
				String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "testequadis";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += "//" + "testequadis";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "noDatetimeStringSync=true";
				String dbschema_tDBInput_1 = "testequadis";

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "select \nclientDoc,\nclientName,\nvalue,\naccountId\nfromtestequadis";

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row5.clientDoc = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.clientDoc = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row5.clientDoc = tmpContent_tDBInput_1;
								}
							} else {
								row5.clientDoc = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row5.clientName = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.clientName = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row5.clientName = tmpContent_tDBInput_1;
								}
							} else {
								row5.clientName = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row5.value = null;
						} else {

							row5.value = rs_tDBInput_1.getBigDecimal(3);
							if (rs_tDBInput_1.wasNull()) {
								row5.value = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row5.accountId = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row5.accountId = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row5.accountId = tmpContent_tDBInput_1;
								}
							} else {
								row5.accountId = null;
							}
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 main ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						if (enableLogStash) {
							runStat.log(iterateId, 1, 1, "row5");
						}

						if (log.isTraceEnabled()) {
							log.trace("row5 - " + (row5 == null ? "" : row5.toLogString()));
						}

						row5Struct row5_HashRow = new row5Struct();

						row5_HashRow.clientDoc = row5.clientDoc;

						row5_HashRow.clientName = row5.clientName;

						row5_HashRow.value = row5.value;

						row5_HashRow.accountId = row5.accountId;

						tHash_Lookup_row5.put(row5_HashRow);

						tos_count_tAdvancedHash_row5++;

						/**
						 * [tAdvancedHash_row5 main ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_1 - Connection to the database closed.");

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row5 end ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				tHash_Lookup_row5.endPut();

				if (enableLogStash) {

					if (runStat.log(resourceMap, iterateId, "row5", 2, 0, talendJobLog, "tDBInput_1", "tMSSqlInput",
							"tAdvancedHash_row5", "tAdvancedHash", "output")) {
						talendJobLogProcess(globalMap);
					}

				}

				ok_Hash.put("tAdvancedHash_row5", true);
				end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row5 end ] stop
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
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row5 finally ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				/**
				 * [tAdvancedHash_row5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];
		static byte[] commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[0];

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
				if (length > commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length) {
					if (length < 1024 && commonByteArray_LOCAL_PROJECT_checkFoundsClient_API.length == 0) {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[1024];
					} else {
						commonByteArray_LOCAL_PROJECT_checkFoundsClient_API = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length);
				strReturn = new String(commonByteArray_LOCAL_PROJECT_checkFoundsClient_API, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_LOCAL_PROJECT_checkFoundsClient_API) {

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
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
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

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[14];

					public void addRow(String[] row) {

						for (int i = 0; i < 14; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 13 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 13 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
							sbformat.append("s");

							sbformat.append("|%5$-");
							sbformat.append(colLengths[4]);
							sbformat.append("s");

							sbformat.append("|%6$-");
							sbformat.append(colLengths[5]);
							sbformat.append("s");

							sbformat.append("|%7$-");
							sbformat.append(colLengths[6]);
							sbformat.append("s");

							sbformat.append("|%8$-");
							sbformat.append(colLengths[7]);
							sbformat.append("s");

							sbformat.append("|%9$-");
							sbformat.append(colLengths[8]);
							sbformat.append("s");

							sbformat.append("|%10$-");
							sbformat.append(colLengths[9]);
							sbformat.append("s");

							sbformat.append("|%11$-");
							sbformat.append(colLengths[10]);
							sbformat.append("s");

							sbformat.append("|%12$-");
							sbformat.append(colLengths[11]);
							sbformat.append("s");

							sbformat.append("|%13$-");
							sbformat.append(colLengths[12]);
							sbformat.append("s");

							sbformat.append("|%14$-");
							sbformat.append(colLengths[13]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[11] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[12] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[13] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("tLogRow_1");
				util_tLogRow_1.addRow(new String[] { "moment", "pid", "father_pid", "root_pid", "system_pid", "project",
						"job", "job_repository_id", "job_version", "context", "origin", "message_type", "message",
						"duration", });
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

					String[] row_tLogRow_1 = new String[14];

					if (row3.moment != null) { //
						row_tLogRow_1[0] = FormatterUtils.format_Date(row3.moment, "yyyy-MM-dd HH:mm:ss");

					} //

					if (row3.pid != null) { //
						row_tLogRow_1[1] = String.valueOf(row3.pid);

					} //

					if (row3.father_pid != null) { //
						row_tLogRow_1[2] = String.valueOf(row3.father_pid);

					} //

					if (row3.root_pid != null) { //
						row_tLogRow_1[3] = String.valueOf(row3.root_pid);

					} //

					if (row3.system_pid != null) { //
						row_tLogRow_1[4] = String.valueOf(row3.system_pid);

					} //

					if (row3.project != null) { //
						row_tLogRow_1[5] = String.valueOf(row3.project);

					} //

					if (row3.job != null) { //
						row_tLogRow_1[6] = String.valueOf(row3.job);

					} //

					if (row3.job_repository_id != null) { //
						row_tLogRow_1[7] = String.valueOf(row3.job_repository_id);

					} //

					if (row3.job_version != null) { //
						row_tLogRow_1[8] = String.valueOf(row3.job_version);

					} //

					if (row3.context != null) { //
						row_tLogRow_1[9] = String.valueOf(row3.context);

					} //

					if (row3.origin != null) { //
						row_tLogRow_1[10] = String.valueOf(row3.origin);

					} //

					if (row3.message_type != null) { //
						row_tLogRow_1[11] = String.valueOf(row3.message_type);

					} //

					if (row3.message != null) { //
						row_tLogRow_1[12] = String.valueOf(row3.message);

					} //

					if (row3.duration != null) { //
						row_tLogRow_1[13] = String.valueOf(row3.duration);

					} //

					util_tLogRow_1.addRow(row_tLogRow_1);
					nb_line_tLogRow_1++;
					log.info("tLogRow_1 - Content of row " + nb_line_tLogRow_1 + ": "
							+ TalendString.unionString("|", row_tLogRow_1));
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

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
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
		final checkFoundsClient_API checkFoundsClient_APIClass = new checkFoundsClient_API();

		int exitCode = checkFoundsClient_APIClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'checkFoundsClient_API' - Done.");
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
		log.info("TalendJob: 'checkFoundsClient_API' - Start.");

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
			java.io.InputStream inContext = checkFoundsClient_API.class.getClassLoader().getResourceAsStream(
					"local_project/checkfoundsclient_api_1_0/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = checkFoundsClient_API.class.getClassLoader()
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
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : checkFoundsClient_API");
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
 * 196823 characters generated by Talend Data Management Platform on the 12 de
 * Novembro de 2023 14h46min39s GMT
 ************************************************************************************************/