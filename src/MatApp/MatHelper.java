package MatApp;


/**
* MatApp/MatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Mat.idl
* jueves 29 de marzo de 2018 02:28:07 PM VET
*/

abstract public class MatHelper
{
  private static String  _id = "IDL:MatApp/Mat:1.0";

  public static void insert (org.omg.CORBA.Any a, MatApp.Mat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static MatApp.Mat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (MatApp.MatHelper.id (), "Mat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static MatApp.Mat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_MatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, MatApp.Mat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static MatApp.Mat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MatApp.Mat)
      return (MatApp.Mat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MatApp._MatStub stub = new MatApp._MatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static MatApp.Mat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof MatApp.Mat)
      return (MatApp.Mat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      MatApp._MatStub stub = new MatApp._MatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
