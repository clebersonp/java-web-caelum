<%@ attribute required="true" name="id" %>

<input name="${id}" id="${id}"><br/>
<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>