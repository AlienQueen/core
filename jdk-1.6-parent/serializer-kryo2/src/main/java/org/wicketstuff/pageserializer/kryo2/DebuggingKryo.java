package org.wicketstuff.pageserializer.kryo2;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.util.lang.Args;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wicketstuff.pageserializer.kryo2.inspecting.InspectingKryo;

import com.esotericsoftware.kryo.io.Output;

import de.javakaffee.kryoserializers.KryoReflectionFactorySupport;

/**
 * An extension of {@link KryoReflectionFactorySupport} that logs the serialized objects and the
 * current size of the buffer after the write. Additionally provides the functionality to blacklist
 * the serialization of specific classes.
 * 
 * @deprecated
 * @see InspectingKryo
 */
@Deprecated
public class DebuggingKryo extends KryoReflectionFactorySupport
{

	private final static Logger LOG = LoggerFactory.getLogger(DebuggingKryo.class);

	private final List<Class<?>> blackList;

	public DebuggingKryo()
	{
		blackList = new ArrayList<Class<?>>();
	}

	public DebuggingKryo blacklist(final Class<?>... classes)
	{
		Args.notNull(classes, "classes");

		for (Class<?> cls : classes)
		{
			blackList.add(cls);
		}
		return this;
	}

	@Override
	public void writeClassAndObject(Output buffer, Object object)
	{

		if (object != null)
		{
			Class<? extends Object> target = object.getClass();
			for (Class<?> cls : blackList)
			{
				if (cls.isAssignableFrom(target))
				{
					throw new IllegalArgumentException("Should not serialize class with type: " +
						cls.getName());
				}
			}
		}
		super.writeClassAndObject(buffer, object);

		if (object != null)
		{
			LOG.error("Wrote '{}' bytes for object: '{}'", buffer.position(), object.getClass());
		}
	}

}
