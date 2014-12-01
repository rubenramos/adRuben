using System;

namespace PReflection
{
	public class NotBlankAttribute : ValidationAttribute
	{
		private string message = "No puede ser que el campo esté vacío.";
		public override string Validate (object value)
		{
				if (value == null || value.ToString ().Trim () == "")
					return message;
				return null;
		}
	}
}

